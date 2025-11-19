package tau.smlab.syntech.generator;

import com.google.common.collect.Iterators;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import tau.smlab.syntech.spectra.Model;

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
    _builder.append("print(");
    String _name = model.getName();
    _builder.append(_name);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
