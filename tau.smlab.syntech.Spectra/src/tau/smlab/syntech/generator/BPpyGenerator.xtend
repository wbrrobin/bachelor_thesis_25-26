package tau.smlab.syntech.generator

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import tau.smlab.syntech.spectra.Constant
import tau.smlab.syntech.spectra.Define
import tau.smlab.syntech.spectra.DefineDecl
import tau.smlab.syntech.spectra.Model
import tau.smlab.syntech.spectra.QuantifierExpr
import tau.smlab.syntech.spectra.SizeDefineDecl
import tau.smlab.syntech.spectra.TemporalAdditiveExpr
import tau.smlab.syntech.spectra.TemporalAndExpr
import tau.smlab.syntech.spectra.TemporalBinaryExpr
import tau.smlab.syntech.spectra.TemporalExpression
import tau.smlab.syntech.spectra.TemporalIffExpr
import tau.smlab.syntech.spectra.TemporalImpExpr
import tau.smlab.syntech.spectra.TemporalInExpr
import tau.smlab.syntech.spectra.TemporalMultiplicativeExpr
import tau.smlab.syntech.spectra.TemporalOrExpr
import tau.smlab.syntech.spectra.TemporalPrimaryExpr
import tau.smlab.syntech.spectra.TemporalRelationalExpr
import tau.smlab.syntech.spectra.TemporalRemainderExpr
import tau.smlab.syntech.spectra.TemporalUnaryExpr
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
	
	def String compile(Model model) '''
		from bppy import *
		import numpy as np
			
		«FOR variable : model.elements.filter(typeof(TypeDef))»
		«variable.compile»
		«ENDFOR»
		
		«FOR variable : model.elements.filter(typeof(Var))»
		«variable.compile»
		«ENDFOR»
		
		«FOR variable : model.elements.filter(typeof(Define))»
		«variable.compile»
		«ENDFOR»
	'''
	
	// = Define ===========================================================================================================================================
	
	def String compile(Define define) '''
		«FOR defineDecl : define.defineList»
		«defineDecl.compile»
		«ENDFOR»
	'''
	
	def String compile(DefineDecl defineDecl) {
		if (defineDecl.simpleExpr !== null) {
			return defineDecl.name + " = " + defineDecl.simpleExpr.translateTempExpr
		} else {
			// TODO array define, z.B. define t[3] := {7, 8, 9};
		}
	}
	
	def dispatch String translateTempExpr(TemporalExpression expr) {
		return expr.translateTempExpr
	}
	
	def dispatch String translateTempExpr(QuantifierExpr expr) {
		// TODO
	}
	
	def dispatch String translateTempExpr(TemporalInExpr expr) {
		// TODO
	}
	
	def dispatch String translateTempExpr(TemporalImpExpr expr) {
		return buildString("Implies(", expr.left.translateTempExpr, ", ", expr.implication.translateTempExpr)
	}
	
	def dispatch String translateTempExpr(TemporalIffExpr expr) {
		return expr.elements.map[it.translateTempExpr].join(" == ")
	}
	
	def dispatch String translateTempExpr(TemporalOrExpr expr) {
		val elements = expr.elements
		
		var result = elements.head.translateTempExpr  
		for (i : 0 ..< expr.operator.size) {
			val operator = expr.operator.get(i)
			val right = elements.get(i + 1).translateTempExpr
			
			result = if (operator == "xor") {
				buildString("Xor(", result, ", ", right, ")")
			} else {
				buildString("Or(", result, ", ", right, ")") // TODO: optimize - Or(a, b, c) instead of Or(Or(a, b), c)
			}
		}
		
		return result
	}
	
	def dispatch String translateTempExpr(TemporalAndExpr expr) {
		return "And(" + expr.elements.map[it.translateTempExpr].join(", ") + ")"
	}
	
	def dispatch String translateTempExpr(TemporalRelationalExpr expr) {
		val left = expr.left
		val operator = expr.operator
		
		if (operator == "=") {
			return left.translateTempExpr + " == " + expr.right.translateTempExpr
		}
		
		return left.translateTempExpr + " " + operator + " " + expr.right.translateTempExpr
	}
	
	def dispatch String translateTempExpr(TemporalRemainderExpr expr) {
		return expr.left.translateTempExpr + " " + expr.operator + " " + expr.right.translateTempExpr
	}
	
	def dispatch String translateTempExpr(TemporalAdditiveExpr expr) {
		val elements = expr.elements
		
		val result = new StringBuilder(elements.head.translateTempExpr)
		for (i : 0 ..< expr.operator.size) {
			val operator = expr.operator.get(i)
			val right = elements.get(i + 1).translateTempExpr
			
			result.append(" ")
			result.append(operator)
			result.append(" ")
			result.append(right)
		}
		
		return result.toString
	}
	
	def dispatch String translateTempExpr(TemporalMultiplicativeExpr expr) {
		val elements = expr.elements
		
		val result = new StringBuilder(elements.head.translateTempExpr)
		for (i : 0 ..< expr.operator.size) {
			val operator = expr.operator.get(i)
			val right = elements.get(i + 1).translateTempExpr
			
			result.append(" ")
			result.append(operator)
			result.append(" ")
			result.append(right)
		}
		
		return result.toString
	}
	
	def dispatch String translateTempExpr(TemporalBinaryExpr expr) {
		// TODO: SINCE, TRIGGERED
	}
	
	def dispatch String translateTempExpr(TemporalUnaryExpr expr) {
		// TODO PREV, HISTORICALLY, ONCE
	}
	
	def dispatch String translateTempExpr(TemporalPrimaryExpr expr) {
		if (expr.operator !== null) {
			return expr.operator + expr.translateTempExpr
		} else if (expr.pointer !== null) {
			return expr.pointer.name
		}
		
		// TODO next, regexp, .all, .any, ...
	}
	
	def dispatch String translateTempExpr(Constant expr) {
		if (expr.booleanValue !== null) {
			return expr.booleanValue.toLowerCase
		} else {
			return expr.integerValue.toString
		}
	}
	
	// = TypeDef ==========================================================================================================================================
	
	def compile(TypeDef typeDef) {
		val name = typeDef.name
		val type = typeDef.type
		
		return switch type {
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
	
	// = Var ==============================================================================================================================================
	
	def String compile(Var variable) {
		val name = variable.^var.name
		val type = variable.^var.type
		
		return switch type {
			case type.name == "boolean" : declareVariable(name, "Bool", null, type.dimensions)
			case type.subr !== null : addInt(name, type)
			case type.type !== null : declareVariable(name, "Const", type.type.name, type.dimensions) // TODO upper lower berücksichtigen wenn man instanceof intsort hat
			case type.const !== null : addEnum(name, type)
		}	
	}
	
	def String buildString(String... strings) {
		val builder = new StringBuilder
		for (s : strings) {
			builder.append(s)
		}
		return builder.toString
	}
	
	def String declareVariable(String name, String type, String constType, EList<SizeDefineDecl> dimensions) {
		return if (dimensions.empty) {
			createVariable(name, type, constType)
		} else {
			createArray(name, type, constType, dimensions)
		}
	}
	
	def String createVariable(String name, String type, String constType) {
		return if (constType === null) {
			buildString(name, " = ", type, "('", name, "')")
		} else {
			buildString(name, " = Const('", name, "', ", constType, ")")
		}
	}
	
	def String createArray(String name, String type, EList<SizeDefineDecl> dimensions) {
		return createArray(name, type, null, dimensions)
	}
	
	def String createArray(String name, String type, String constType, EList<SizeDefineDecl> dimensions) {
		val prefix = new StringBuilder
		val elemName = new StringBuilder(name)
		val postfix = new StringBuilder
		
		// Add list comprehension if the variable is an array
		for (dim : 0 ..< dimensions.size) {
			prefix.append("[")
			elemName.append("_{i" + dim + "}")
			postfix.insert(0, " for i" + dim + " in range(" + dimensions.get(dim).value + ")]")
		}
		
		val constAttribute = constType !== null ? ", " + constType : ""
		return buildString(name, " = ", prefix.toString, type, "(f'", elemName.toString, "'", constAttribute, ")", postfix.toString)
	}
	
	def String addInt(String name, VarType type) '''
		
		«declareVariable(name, "Int", null, type.dimensions)»
		«/* TODO: handle other ways of modeling subranges (e.g. with a Define N := 4) */»
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
	
	def String addEnum(String name, VarType type) '''
		«createEnumType(name, type.const)»
		«declareVariable(name, "Const", name.toFirstUpper, type.dimensions)»
	'''
}