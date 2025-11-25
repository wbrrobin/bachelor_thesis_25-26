package tau.smlab.syntech.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import tau.smlab.syntech.spectra.Model;
import tau.smlab.syntech.spectra.SizeDefineDecl;
import tau.smlab.syntech.spectra.Subrange;
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

  public CharSequence compile(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("from bppy import *");
    _builder.newLine();
    _builder.append("import numpy as np");
    _builder.newLine();
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
        CharSequence _compile_1 = this.compile(variable_1.getVar().getType(), variable_1.getVar().getName());
        _builder.append(_compile_1);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence compile(final TypeDef typeDef) {
    CharSequence _xblockexpression = null;
    {
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
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
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

  public CharSequence compile(final VarType type, final String name) {
    CharSequence _switchResult = null;
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

  private String buildString(final List<String> strings) {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder();
      for (final String s : strings) {
        builder.append(s);
      }
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }

  public String declareVariable(final String name, final String type, final String constType, final EList<SizeDefineDecl> dimensions) {
    String _xifexpression = null;
    int _size = dimensions.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      _xifexpression = this.createVariable(name, type, constType);
    } else {
      _xifexpression = this.createArray(name, type, constType, dimensions);
    }
    return _xifexpression;
  }

  public String createVariable(final String name, final String type, final String constType) {
    String _xifexpression = null;
    if ((constType == null)) {
      _xifexpression = this.buildString(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(name, " = ", type, "(\'", name, "\')")));
    } else {
      _xifexpression = this.buildString(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(name, " = Const(\'", name, "\', ", constType, ")")));
    }
    return _xifexpression;
  }

  public String createArray(final String name, final String type, final EList<SizeDefineDecl> dimensions) {
    return this.createArray(name, type, null, dimensions);
  }

  public String createArray(final String name, final String type, final String constType, final EList<SizeDefineDecl> dimensions) {
    String _xblockexpression = null;
    {
      final StringBuilder prefix = new StringBuilder();
      final StringBuilder elemName = new StringBuilder(name);
      final StringBuilder postfix = new StringBuilder();
      for (int dim = 0; (dim < dimensions.size()); dim++) {
        {
          prefix.append("[");
          elemName.append((("_{i" + Integer.valueOf(dim)) + "}"));
          int _value = dimensions.get(dim).getValue();
          String _plus = (((" for i" + Integer.valueOf(dim)) + " in range(") + Integer.valueOf(_value));
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
      String _string = prefix.toString();
      String _string_1 = elemName.toString();
      String _string_2 = postfix.toString();
      _xblockexpression = this.buildString(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(name, " = ", _string, type, "(f\'", _string_1, "\'", constAttribute, ")", _string_2)));
    }
    return _xblockexpression;
  }

  public CharSequence addInt(final String name, final VarType type) {
    StringConcatenation _builder = new StringConcatenation();
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
    return _builder;
  }

  public CharSequence addEnum(final String name, final VarType type) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _createEnumType = this.createEnumType(name, type.getConst());
    _builder.append(_createEnumType);
    _builder.newLineIfNotEmpty();
    String _declareVariable = this.declareVariable(name, "Const", StringExtensions.toFirstUpper(name), type.getDimensions());
    _builder.append(_declareVariable);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
