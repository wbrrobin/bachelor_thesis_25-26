package tau.smlab.syntech.generator

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import tau.smlab.syntech.spectra.Model
import tau.smlab.syntech.spectra.SizeDefineDecl
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
		
		«FOR variable : model.elements.filter(typeof(Var))»
		«variable.^var.type.compile(variable.^var.name)»
		«ENDFOR»
	'''
	
	def compile(VarType type, String name) {
		switch type {
			case type.name == "boolean" : getVarDeclaration(name, "Bool", type.dimensions)
			case type.subr !== null : addInt(type, name)
			case type.const !== null : addEnum(type, name)
			//case type.type !== null : // TODO
		}	
	}
	
	def String getVarDeclaration(String varName, String typeName, EList<SizeDefineDecl> dimensions) {
		val isArray = dimensions.size != 0
		// If the variable is an enum, the resulting SMT-Variable gets a second argument, e.g.:
		// act = Const('act', Act) instead of act = Const('act')
		val isEnum = typeName == "Const"
		val secondArgument = isEnum ? ", " + varName.toFirstUpper : ""
		
		if (!isArray) {
			return new StringBuilder(varName)
				.append(" = ")
				.append(typeName)
				.append("('")
				.append(varName)
				.append("'")
				.append(secondArgument)
				.append(")")
				.toString
		}
		
		val prefix = new StringBuilder
		val elemName = new StringBuilder(varName)
		val postfix = new StringBuilder
		
		// Add list comprehension if the variable is an array
		for (var dim = 0; dim < dimensions.size; dim++) {
			prefix.append("[")
			elemName.append("_{i" + dim + "}")
			postfix.insert(0, " for i" + dim + " in range(" + dimensions.get(dim).value + ")]")
		}
		
		return new StringBuilder(varName) 
			.append(" = ") 
			.append(prefix.toString) 
			.append(typeName) 
			.append("(f'")
			.append(elemName.toString)
			.append("'")
			.append(secondArgument)
			.append(")")
			.append(postfix.toString)
			.toString
	}
	
	def addInt(VarType type, String name) '''
		«getVarDeclaration(name, "Int", type.dimensions)»
		
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
	
	def addEnum(VarType type, String name) '''
		«name.toFirstUpper», («type.const.map[it.name.toFirstLower].join(", ")») \
			= EnumSort('«name.toFirstUpper»', («type.const.map["'" + it.name + "'"].join(", ")»))
		«getVarDeclaration(name, "Const", type.dimensions)»
	'''
}