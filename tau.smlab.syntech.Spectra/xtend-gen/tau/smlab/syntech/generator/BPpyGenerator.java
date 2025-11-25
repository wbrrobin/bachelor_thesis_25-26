package tau.smlab.syntech.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import tau.smlab.syntech.spectra.Model;
import tau.smlab.syntech.spectra.SizeDefineDecl;
import tau.smlab.syntech.spectra.Subrange;
import tau.smlab.syntech.spectra.TypeConstant;
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
      Iterable<Var> _filter = Iterables.<Var>filter(model.getElements(), Var.class);
      for(final Var variable : _filter) {
        CharSequence _compile = this.compile(variable.getVar().getType(), variable.getVar().getName());
        _builder.append(_compile);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence compile(final VarType type, final String name) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    String _name = type.getName();
    boolean _equals = Objects.equal(_name, "boolean");
    if (_equals) {
      _matched=true;
      _switchResult = this.getVarDeclaration(name, "Bool", type.getDimensions());
    }
    if (!_matched) {
      Subrange _subr = type.getSubr();
      boolean _tripleNotEquals = (_subr != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = this.addInt(type, name);
      }
    }
    if (!_matched) {
      EList<TypeConstant> _const = type.getConst();
      boolean _tripleNotEquals_1 = (_const != null);
      if (_tripleNotEquals_1) {
        _matched=true;
        _switchResult = this.addEnum(type, name);
      }
    }
    return _switchResult;
  }

  public String getVarDeclaration(final String varName, final String typeName, final EList<SizeDefineDecl> dimensions) {
    int _size = dimensions.size();
    final boolean isArray = (_size != 0);
    final boolean isEnum = Objects.equal(typeName, "Const");
    String _xifexpression = null;
    if (isEnum) {
      String _firstUpper = StringExtensions.toFirstUpper(varName);
      _xifexpression = (", " + _firstUpper);
    } else {
      _xifexpression = "";
    }
    final String secondArgument = _xifexpression;
    if ((!isArray)) {
      return new StringBuilder(varName).append(" = ").append(typeName).append("(\'").append(varName).append("\'").append(secondArgument).append(")").toString();
    }
    final StringBuilder prefix = new StringBuilder();
    final StringBuilder elemName = new StringBuilder(varName);
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
    return new StringBuilder(varName).append(" = ").append(prefix.toString()).append(typeName).append("(f\'").append(elemName.toString()).append("\'").append(secondArgument).append(")").append(postfix.toString()).toString();
  }

  public CharSequence addInt(final VarType type, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    String _varDeclaration = this.getVarDeclaration(name, "Int", type.getDimensions());
    _builder.append(_varDeclaration);
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

  public CharSequence addEnum(final VarType type, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper);
    _builder.append(", (");
    final Function1<TypeConstant, String> _function = (TypeConstant it) -> {
      return StringExtensions.toFirstLower(it.getName());
    };
    String _join = IterableExtensions.join(ListExtensions.<TypeConstant, String>map(type.getConst(), _function), ", ");
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
    String _join_1 = IterableExtensions.join(ListExtensions.<TypeConstant, String>map(type.getConst(), _function_1), ", ");
    _builder.append(_join_1, "\t");
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    String _varDeclaration = this.getVarDeclaration(name, "Const", type.getDimensions());
    _builder.append(_varDeclaration);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
