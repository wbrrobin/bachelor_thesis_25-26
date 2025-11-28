package tau.smlab.syntech.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import tau.smlab.syntech.spectra.Constant;
import tau.smlab.syntech.spectra.Define;
import tau.smlab.syntech.spectra.DefineDecl;
import tau.smlab.syntech.spectra.Model;
import tau.smlab.syntech.spectra.QuantifierExpr;
import tau.smlab.syntech.spectra.Referrable;
import tau.smlab.syntech.spectra.SizeDefineDecl;
import tau.smlab.syntech.spectra.Subrange;
import tau.smlab.syntech.spectra.TemporalAdditiveExpr;
import tau.smlab.syntech.spectra.TemporalAndExpr;
import tau.smlab.syntech.spectra.TemporalBinaryExpr;
import tau.smlab.syntech.spectra.TemporalExpression;
import tau.smlab.syntech.spectra.TemporalIffExpr;
import tau.smlab.syntech.spectra.TemporalImpExpr;
import tau.smlab.syntech.spectra.TemporalInExpr;
import tau.smlab.syntech.spectra.TemporalMultiplicativeExpr;
import tau.smlab.syntech.spectra.TemporalOrExpr;
import tau.smlab.syntech.spectra.TemporalPrimaryExpr;
import tau.smlab.syntech.spectra.TemporalRelationalExpr;
import tau.smlab.syntech.spectra.TemporalRemainderExpr;
import tau.smlab.syntech.spectra.TemporalUnaryExpr;
import tau.smlab.syntech.spectra.TypeConstant;
import tau.smlab.syntech.spectra.TypeDef;
import tau.smlab.syntech.spectra.Var;
import tau.smlab.syntech.spectra.VarType;

@SuppressWarnings("all")
public class BPpyGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Model model = IteratorExtensions.<Model>head(Iterators.<Model>filter(resource.getAllContents(), Model.class));
    if ((model == null)) {
      return;
    }
    String _lowerCase = model.getName().toLowerCase();
    String _plus = (_lowerCase + ".py");
    fsa.generateFile(_plus, this.compile(model));
  }

  public String compile(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("from bppy import *");
    _builder.newLine();
    _builder.append("import numpy as np");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<TypeDef> _filter = Iterables.<TypeDef>filter(model.getElements(), TypeDef.class);
      for(final TypeDef variable : _filter) {
        CharSequence _compile = this.compile(variable);
        _builder.append(_compile);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      Iterable<Var> _filter_1 = Iterables.<Var>filter(model.getElements(), Var.class);
      for(final Var variable_1 : _filter_1) {
        String _compile_1 = this.compile(variable_1);
        _builder.append(_compile_1);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      Iterable<Define> _filter_2 = Iterables.<Define>filter(model.getElements(), Define.class);
      for(final Define variable_2 : _filter_2) {
        String _compile_2 = this.compile(variable_2);
        _builder.append(_compile_2);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  public String compile(final Define define) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<DefineDecl> _defineList = define.getDefineList();
      for(final DefineDecl defineDecl : _defineList) {
        String _compile = this.compile(defineDecl);
        _builder.append(_compile);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  public String compile(final DefineDecl defineDecl) {
    Object _xifexpression = null;
    TemporalExpression _simpleExpr = defineDecl.getSimpleExpr();
    boolean _tripleNotEquals = (_simpleExpr != null);
    if (_tripleNotEquals) {
      String _name = defineDecl.getName();
      String _plus = (_name + " = ");
      String _translateTempExpr = this.translateTempExpr(defineDecl.getSimpleExpr());
      return (_plus + _translateTempExpr);
    } else {
      _xifexpression = null;
    }
    return ((String)_xifexpression);
  }

  protected String _translateTempExpr(final TemporalExpression expr) {
    return this.translateTempExpr(expr);
  }

  protected String _translateTempExpr(final QuantifierExpr expr) {
    return null;
  }

  protected String _translateTempExpr(final TemporalInExpr expr) {
    return null;
  }

  protected String _translateTempExpr(final TemporalImpExpr expr) {
    return this.buildString("Implies(", this.translateTempExpr(expr.getLeft()), ", ", this.translateTempExpr(expr.getImplication()));
  }

  protected String _translateTempExpr(final TemporalIffExpr expr) {
    final Function1<TemporalExpression, String> _function = (TemporalExpression it) -> {
      return this.translateTempExpr(it);
    };
    return IterableExtensions.join(ListExtensions.<TemporalExpression, String>map(expr.getElements(), _function), " == ");
  }

  protected String _translateTempExpr(final TemporalOrExpr expr) {
    final EList<TemporalExpression> elements = expr.getElements();
    String result = this.translateTempExpr(IterableExtensions.<TemporalExpression>head(elements));
    int _size = expr.getOperator().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final String operator = expr.getOperator().get((i).intValue());
        final String right = this.translateTempExpr(elements.get(((i).intValue() + 1)));
        String _xifexpression = null;
        boolean _equals = Objects.equal(operator, "xor");
        if (_equals) {
          _xifexpression = this.buildString("Xor(", result, ", ", right, ")");
        } else {
          _xifexpression = this.buildString("Or(", result, ", ", right, ")");
        }
        result = _xifexpression;
      }
    }
    return result;
  }

  protected String _translateTempExpr(final TemporalAndExpr expr) {
    final Function1<TemporalExpression, String> _function = (TemporalExpression it) -> {
      return this.translateTempExpr(it);
    };
    String _join = IterableExtensions.join(ListExtensions.<TemporalExpression, String>map(expr.getElements(), _function), ", ");
    String _plus = ("And(" + _join);
    return (_plus + ")");
  }

  protected String _translateTempExpr(final TemporalRelationalExpr expr) {
    final TemporalExpression left = expr.getLeft();
    final String operator = expr.getOperator();
    boolean _equals = Objects.equal(operator, "=");
    if (_equals) {
      String _translateTempExpr = this.translateTempExpr(left);
      String _plus = (_translateTempExpr + " == ");
      String _translateTempExpr_1 = this.translateTempExpr(expr.getRight());
      return (_plus + _translateTempExpr_1);
    }
    String _translateTempExpr_2 = this.translateTempExpr(left);
    String _plus_1 = (_translateTempExpr_2 + " ");
    String _plus_2 = (_plus_1 + operator);
    String _plus_3 = (_plus_2 + " ");
    String _translateTempExpr_3 = this.translateTempExpr(expr.getRight());
    return (_plus_3 + _translateTempExpr_3);
  }

  protected String _translateTempExpr(final TemporalRemainderExpr expr) {
    String _translateTempExpr = this.translateTempExpr(expr.getLeft());
    String _plus = (_translateTempExpr + " ");
    String _operator = expr.getOperator();
    String _plus_1 = (_plus + _operator);
    String _plus_2 = (_plus_1 + " ");
    String _translateTempExpr_1 = this.translateTempExpr(expr.getRight());
    return (_plus_2 + _translateTempExpr_1);
  }

  protected String _translateTempExpr(final TemporalAdditiveExpr expr) {
    final EList<TemporalExpression> elements = expr.getElements();
    String _translateTempExpr = this.translateTempExpr(IterableExtensions.<TemporalExpression>head(elements));
    final StringBuilder result = new StringBuilder(_translateTempExpr);
    int _size = expr.getOperator().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final String operator = expr.getOperator().get((i).intValue());
        final String right = this.translateTempExpr(elements.get(((i).intValue() + 1)));
        result.append(" ");
        result.append(operator);
        result.append(" ");
        result.append(right);
      }
    }
    return result.toString();
  }

  protected String _translateTempExpr(final TemporalMultiplicativeExpr expr) {
    final EList<TemporalExpression> elements = expr.getElements();
    String _translateTempExpr = this.translateTempExpr(IterableExtensions.<TemporalExpression>head(elements));
    final StringBuilder result = new StringBuilder(_translateTempExpr);
    int _size = expr.getOperator().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final String operator = expr.getOperator().get((i).intValue());
        final String right = this.translateTempExpr(elements.get(((i).intValue() + 1)));
        result.append(" ");
        result.append(operator);
        result.append(" ");
        result.append(right);
      }
    }
    return result.toString();
  }

  protected String _translateTempExpr(final TemporalBinaryExpr expr) {
    return null;
  }

  protected String _translateTempExpr(final TemporalUnaryExpr expr) {
    return null;
  }

  protected String _translateTempExpr(final TemporalPrimaryExpr expr) {
    String _operator = expr.getOperator();
    boolean _tripleNotEquals = (_operator != null);
    if (_tripleNotEquals) {
      String _operator_1 = expr.getOperator();
      String _translateTempExpr = this.translateTempExpr(expr);
      return (_operator_1 + _translateTempExpr);
    } else {
      Referrable _pointer = expr.getPointer();
      boolean _tripleNotEquals_1 = (_pointer != null);
      if (_tripleNotEquals_1) {
        return expr.getPointer().getName();
      }
    }
    return null;
  }

  protected String _translateTempExpr(final Constant expr) {
    String _booleanValue = expr.getBooleanValue();
    boolean _tripleNotEquals = (_booleanValue != null);
    if (_tripleNotEquals) {
      return expr.getBooleanValue().toLowerCase();
    } else {
      return Integer.valueOf(expr.getIntegerValue()).toString();
    }
  }

  public CharSequence compile(final TypeDef typeDef) {
    final String name = typeDef.getName();
    final VarType type = typeDef.getType();
    CharSequence _switchResult = null;
    boolean _matched = false;
    String _name = type.getName();
    boolean _equals = Objects.equal(_name, "boolean");
    if (_equals) {
      _matched=true;
      _switchResult = (name + " = BoolSort()");
    }
    if (!_matched) {
      Subrange _subr = type.getSubr();
      boolean _tripleNotEquals = (_subr != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = (name + " = IntSort()");
      }
    }
    if (!_matched) {
      TypeDef _type = type.getType();
      boolean _tripleNotEquals_1 = (_type != null);
      if (_tripleNotEquals_1) {
        _matched=true;
        String _name_1 = type.getType().getName();
        _switchResult = ((name + " = ") + _name_1);
      }
    }
    if (!_matched) {
      EList<TypeConstant> _const = type.getConst();
      boolean _tripleNotEquals_2 = (_const != null);
      if (_tripleNotEquals_2) {
        _matched=true;
        _switchResult = this.createEnumType(name, type.getConst());
      }
    }
    return _switchResult;
  }

  public CharSequence createEnumType(final String name, final EList<TypeConstant> constants) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper);
    _builder.append(", (");
    final Function1<TypeConstant, String> _function = (TypeConstant it) -> {
      return it.getName();
    };
    String _join = IterableExtensions.join(ListExtensions.<TypeConstant, String>map(constants, _function), ", ");
    _builder.append(_join);
    _builder.append(") \\");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("= EnumSort(\'");
    String _firstUpper_1 = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper_1, "\t");
    _builder.append("\', (");
    final Function1<TypeConstant, String> _function_1 = (TypeConstant it) -> {
      String _name = it.getName();
      String _plus = ("\'" + _name);
      return (_plus + "\'");
    };
    String _join_1 = IterableExtensions.join(ListExtensions.<TypeConstant, String>map(constants, _function_1), ", ");
    _builder.append(_join_1, "\t");
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public String compile(final Var variable) {
    final String name = variable.getVar().getName();
    final VarType type = variable.getVar().getType();
    String _switchResult = null;
    boolean _matched = false;
    String _name = type.getName();
    boolean _equals = Objects.equal(_name, "boolean");
    if (_equals) {
      _matched=true;
      _switchResult = this.declareVariable(name, "Bool", null, type.getDimensions());
    }
    if (!_matched) {
      Subrange _subr = type.getSubr();
      boolean _tripleNotEquals = (_subr != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = this.addInt(name, type);
      }
    }
    if (!_matched) {
      TypeDef _type = type.getType();
      boolean _tripleNotEquals_1 = (_type != null);
      if (_tripleNotEquals_1) {
        _matched=true;
        _switchResult = this.declareVariable(name, "Const", type.getType().getName(), type.getDimensions());
      }
    }
    if (!_matched) {
      EList<TypeConstant> _const = type.getConst();
      boolean _tripleNotEquals_2 = (_const != null);
      if (_tripleNotEquals_2) {
        _matched=true;
        _switchResult = this.addEnum(name, type);
      }
    }
    return _switchResult;
  }

  public String buildString(final String... strings) {
    final StringBuilder builder = new StringBuilder();
    for (final String s : strings) {
      builder.append(s);
    }
    return builder.toString();
  }

  public String declareVariable(final String name, final String type, final String constType, final EList<SizeDefineDecl> dimensions) {
    String _xifexpression = null;
    boolean _isEmpty = dimensions.isEmpty();
    if (_isEmpty) {
      _xifexpression = this.createVariable(name, type, constType);
    } else {
      _xifexpression = this.createArray(name, type, constType, dimensions);
    }
    return _xifexpression;
  }

  public String createVariable(final String name, final String type, final String constType) {
    String _xifexpression = null;
    if ((constType == null)) {
      _xifexpression = this.buildString(name, " = ", type, "(\'", name, "\')");
    } else {
      _xifexpression = this.buildString(name, " = Const(\'", name, "\', ", constType, ")");
    }
    return _xifexpression;
  }

  public String createArray(final String name, final String type, final EList<SizeDefineDecl> dimensions) {
    return this.createArray(name, type, null, dimensions);
  }

  public String createArray(final String name, final String type, final String constType, final EList<SizeDefineDecl> dimensions) {
    final StringBuilder prefix = new StringBuilder();
    final StringBuilder elemName = new StringBuilder(name);
    final StringBuilder postfix = new StringBuilder();
    int _size = dimensions.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer dim : _doubleDotLessThan) {
      {
        prefix.append("[");
        elemName.append((("_{i" + dim) + "}"));
        int _value = dimensions.get((dim).intValue()).getValue();
        String _plus = (((" for i" + dim) + " in range(") + Integer.valueOf(_value));
        String _plus_1 = (_plus + ")]");
        postfix.insert(0, _plus_1);
      }
    }
    String _xifexpression = null;
    if ((constType != null)) {
      _xifexpression = (", " + constType);
    } else {
      _xifexpression = "";
    }
    final String constAttribute = _xifexpression;
    return this.buildString(name, " = ", prefix.toString(), type, "(f\'", elemName.toString(), "\'", constAttribute, ")", postfix.toString());
  }

  public String addInt(final String name, final VarType type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    String _declareVariable = this.declareVariable(name, "Int", null, type.getDimensions());
    _builder.append(_declareVariable);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@thread");
    _builder.newLine();
    _builder.append("def ");
    _builder.append(name);
    _builder.append("_bounds():");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("lower = ");
    int _value = type.getSubr().getFrom().getValue();
    _builder.append(_value, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("upper = ");
    int _value_1 = type.getSubr().getTo().getValue();
    _builder.append(_value_1, "\t");
    _builder.newLineIfNotEmpty();
    {
      int _size = type.getDimensions().size();
      boolean _equals = (_size == 0);
      if (_equals) {
        _builder.append("\t");
        _builder.append("block_condition = Or(");
        _builder.append(name, "\t");
        _builder.append(" < lower, ");
        _builder.append(name, "\t");
        _builder.append(" > upper)");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t");
        _builder.append("flat_array = np.array(");
        _builder.append(name, "\t");
        _builder.append(").flatten()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("block_condition = Or(*[Or(elem < lower, elem > upper) for elem in flat_array])");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("yield sync(block=block_condition)");
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }

  public String addEnum(final String name, final VarType type) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _createEnumType = this.createEnumType(name, type.getConst());
    _builder.append(_createEnumType);
    _builder.newLineIfNotEmpty();
    String _declareVariable = this.declareVariable(name, "Const", StringExtensions.toFirstUpper(name), type.getDimensions());
    _builder.append(_declareVariable);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public String translateTempExpr(final TemporalExpression expr) {
    if (expr instanceof Constant) {
      return _translateTempExpr((Constant)expr);
    } else if (expr instanceof QuantifierExpr) {
      return _translateTempExpr((QuantifierExpr)expr);
    } else if (expr instanceof TemporalAdditiveExpr) {
      return _translateTempExpr((TemporalAdditiveExpr)expr);
    } else if (expr instanceof TemporalAndExpr) {
      return _translateTempExpr((TemporalAndExpr)expr);
    } else if (expr instanceof TemporalBinaryExpr) {
      return _translateTempExpr((TemporalBinaryExpr)expr);
    } else if (expr instanceof TemporalIffExpr) {
      return _translateTempExpr((TemporalIffExpr)expr);
    } else if (expr instanceof TemporalImpExpr) {
      return _translateTempExpr((TemporalImpExpr)expr);
    } else if (expr instanceof TemporalInExpr) {
      return _translateTempExpr((TemporalInExpr)expr);
    } else if (expr instanceof TemporalMultiplicativeExpr) {
      return _translateTempExpr((TemporalMultiplicativeExpr)expr);
    } else if (expr instanceof TemporalOrExpr) {
      return _translateTempExpr((TemporalOrExpr)expr);
    } else if (expr instanceof TemporalPrimaryExpr) {
      return _translateTempExpr((TemporalPrimaryExpr)expr);
    } else if (expr instanceof TemporalRelationalExpr) {
      return _translateTempExpr((TemporalRelationalExpr)expr);
    } else if (expr instanceof TemporalRemainderExpr) {
      return _translateTempExpr((TemporalRemainderExpr)expr);
    } else if (expr instanceof TemporalUnaryExpr) {
      return _translateTempExpr((TemporalUnaryExpr)expr);
    } else if (expr != null) {
      return _translateTempExpr(expr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expr).toString());
    }
  }
}
