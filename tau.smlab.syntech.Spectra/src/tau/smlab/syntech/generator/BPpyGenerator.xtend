package tau.smlab.syntech.generator

import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import tau.smlab.syntech.spectra.Model
import tau.smlab.syntech.spectra.SizeDefineDecl
import tau.smlab.syntech.spectra.TypeConstant
import tau.smlab.syntech.spectra.TypeDef
import tau.smlab.syntech.spectra.Var
import tau.smlab.syntech.spectra.VarType

class BPpyGenerator extends AbstractGenerator {
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val model = resource.allContents.filter(typeof(Model)).head
		if (model === null) {
			return
		}
		
		fsa.generateFile(model.name.toLowerCase + ".py", model.compile)			 
	}
	
	def compile(Model model) '''
		from bppy import *
		import numpy as np
		
		«FOR variable : model.elements.filter(typeof(TypeDef))»
		«variable.compile»
		«ENDFOR»
		
		«FOR variable : model.elements.filter(typeof(Var))»
		«variable.^var.type.compile(variable.^var.name)»
		«ENDFOR»
	'''
	
	def compile(TypeDef typeDef) {
		val name = typeDef.name
		val type = typeDef.type
		
		switch type {
			case type.name == "boolean" : name + " = BoolSort()"
			case type.subr !== null : name + " = IntSort()" // TODO add constraint b-threads maybe. otherwise, the constraints are gone. or maybe save them somewhere. or create a class that extends intsort with new lower and upper attributes that can be called later
			case type.type !== null : name + " = " + type.type.name
			case type.const !== null : createEnumType(name, type.const)
		}
	}
	
	def createEnumType(String name, EList<TypeConstant> constants) '''
		«name.toFirstUpper», («constants.map[it.name].join(", ")») \
			= EnumSort('«name.toFirstUpper»', («constants.map["'" + it.name + "'"].join(", ")»))
	'''
	
	def compile(VarType type, String name) {
		switch type {
			case type.name == "boolean" : declareVariable(name, "Bool", null, type.dimensions)
			case type.subr !== null : addInt(name, type)
			case type.type !== null : declareVariable(name, "Const", type.type.name, type.dimensions) // TODO upper lower berücksichtigen wenn man instanceof intsort hat
			case type.const !== null : addEnum(name, type)
		}	
	}
	
	private def buildString(List<String> strings) {
		val builder = new StringBuilder
		for (s : strings) {
			builder.append(s)
		}
		builder.toString
	}
	
	def String declareVariable(String name, String type, String constType, EList<SizeDefineDecl> dimensions) {
		if (dimensions.size == 0) {
			createVariable(name, type, constType)
		} else {
			createArray(name, type, constType, dimensions)
		}
	}
	
	def String createVariable(String name, String type, String constType) {
		if (constType === null) {
			buildString(#[name, " = ", type, "('", name, "')"])
		} else {
			buildString(#[name, " = Const('", name, "', ", constType, ")"])
		}
	}
	
	def String createArray(String name, String type, EList<SizeDefineDecl> dimensions) {
		createArray(name, type, null, dimensions)
	}
	
	def String createArray(String name, String type, String constType, EList<SizeDefineDecl> dimensions) {
		val prefix = new StringBuilder
		val elemName = new StringBuilder(name)
		val postfix = new StringBuilder
		
		// Add list comprehension if the variable is an array
		for (var dim = 0; dim < dimensions.size; dim++) {
			prefix.append("[")
			elemName.append("_{i" + dim + "}")
			postfix.insert(0, " for i" + dim + " in range(" + dimensions.get(dim).value + ")]")
		}
		
		val constAttribute = constType !== null ? ", " + constType : ""
		buildString(#[name, " = ", prefix.toString, type, "(f'", elemName.toString, "'", constAttribute, ")", postfix.toString])
	}
	
	def addInt(String name, VarType type) '''
		«declareVariable(name, "Int", null, type.dimensions)»
		
		@thread
		def «name»_bounds():
			lower = «type.subr.from.value»
			upper = «type.subr.to.value»
			«IF type.dimensions.size == 0»
			block_condition = Or(«name» < lower, «name» > upper)
			«ELSE»
			flat_array = np.array(«name»).flatten()
			block_condition = Or(*[Or(elem < lower, elem > upper) for elem in flat_array])
			«ENDIF»
			yield sync(block=block_condition)
		
	'''
	
	def addEnum(String name, VarType type) '''
		«createEnumType(name, type.const)»
		«declareVariable(name, "Const", name.toFirstUpper, type.dimensions)»
	'''
}