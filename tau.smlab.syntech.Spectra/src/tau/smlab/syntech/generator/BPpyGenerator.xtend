package tau.smlab.syntech.generator

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import tau.smlab.syntech.spectra.Model
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
			case type.name == "boolean" : name + " = Bool('" + name + "')"
			case type.subr !== null : addInt(type.subr, name)
			case type.const !== null : addEnum(type.const, name)
			//case type.type !== null : // TODO
			// TODO: array option
		}
	}
	
	def addInt(Subrange subr, String name) '''
		«name» = Int('«name»')
		
		@thread
		def «name»Bounds():
			yield sync(block=Or(«name» < «subr.from.value», «name» > «subr.to.value»))
	'''
	
	def addEnum(EList<TypeConstant> constants, String name) '''
		«name.toFirstUpper», («constants.map[it.name.toFirstLower].join(", ")») \
			= EnumSort('«name.toFirstUpper»', («constants.map["'" + it.name + "'"].join(", ")»))
		«name» = Const('«name»', «name.toFirstUpper»)
	'''
}