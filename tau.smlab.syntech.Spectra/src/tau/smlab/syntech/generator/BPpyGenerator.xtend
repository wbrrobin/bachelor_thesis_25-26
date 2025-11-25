package tau.smlab.syntech.generator

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import tau.smlab.syntech.spectra.Model
import tau.smlab.syntech.spectra.SizeDefineDecl
import tau.smlab.syntech.spectra.Subrange
import tau.smlab.syntech.spectra.TypeConstant
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
		val prefix = new StringBuilder
		val elemName = new StringBuilder(varName)
		val postfix = new StringBuilder
		
		// Add list comprehension if the variable is an array
		for (var dim = 0; dim < dimensions.size; dim++) {
			prefix.append("[")
			elemName.append("_{i" + dim + "}")
			postfix.insert(0, " for i" + dim + " in range(" + dimensions.get(dim).value + ")]")
		}
		
		return varName 
			+ " = " 
			+ prefix.toString 
			+ typeName 
			+ "(f'"
			+ elemName.toString
			+ "')"
			+ postfix.toString
	}
	
	def addInt(VarType type, String name) '''
		«getVarDeclaration(name, "Int", type.dimensions)»
		
		@thread
		def «name»Bounds():
			yield sync(block=Or(«name» < «type.subr.from.value», «name» > «type.subr.to.value»))
			«/* TODO: Wenn wir ein Array haben, dann sieht der b-Thread anders aus */»
	'''
	
	def addEnum(VarType type, String name) '''
		«name.toFirstUpper», («type.const.map[it.name.toFirstLower].join(", ")») \
			= EnumSort('«name.toFirstUpper»', («type.const.map["'" + it.name + "'"].join(", ")»))
		«name» = Const('«name»', «name.toFirstUpper»)
		«getVarDeclaration(name, "Const", type.dimensions)»
		«/*TODO: bei const gibts nen zweiten parameter der noch fehlt: loc = Const('loc', Loc)*/»
	'''
}