package org.eclipse.xtext.mongobeans.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.mongobeans.jvmmodel.MongoTypes;
import org.eclipse.xtext.mongobeans.mongoBeans.AbstractFeature;
import org.eclipse.xtext.mongobeans.mongoBeans.MongoBean;
import org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation;
import org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class MongoBeansJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  private TypeReferenceSerializer _typeReferenceSerializer;
  
  @Inject
  private MongoTypes _mongoTypes;
  
  @Inject
  private Primitives _primitives;
  
  protected void _infer(final MongoBean bean, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(bean);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(bean, _fullyQualifiedName);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          String _documentation = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(bean);
          MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(bean, "org.eclipse.xtext.mongobeans.IDBObjectWrapper");
          MongoBeansJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
          MongoBeansJvmModelInferrer.this.addConstructors(it, bean);
          MongoBeansJvmModelInferrer.this.addDbObjectProperty(it, bean);
          EcoreUtil.resolveAll(bean);
          EList<AbstractFeature> _features = bean.getFeatures();
          for (final AbstractFeature feature : _features) {
            boolean _matched = false;
            if (!_matched) {
              if (feature instanceof MongoProperty) {
                final MongoProperty _mongoProperty = (MongoProperty)feature;
                _matched=true;
                boolean _isMany = _mongoProperty.isMany();
                if (_isMany) {
                  MongoBeansJvmModelInferrer.this.addListAccessor(it, _mongoProperty);
                } else {
                  MongoBeansJvmModelInferrer.this.addDelegateAccessors(it, _mongoProperty);
                }
              }
            }
            if (!_matched) {
              if (feature instanceof MongoOperation) {
                final MongoOperation _mongoOperation = (MongoOperation)feature;
                _matched=true;
                MongoBeansJvmModelInferrer.this.addMethod(it, _mongoOperation);
              }
            }
          }
        }
      };
    _accept.initializeLater(_function);
  }
  
  protected boolean addConstructors(final JvmDeclaredType inferredType, final MongoBean bean) {
    boolean _xblockexpression = false;
    {
      EList<JvmMember> _members = inferredType.getMembers();
      final Procedure1<JvmConstructor> _function = new Procedure1<JvmConstructor>() {
          public void apply(final JvmConstructor it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Creates a new ");
            String _name = bean.getName();
            _builder.append(_name, "");
            _builder.append(" wrapping the given {@link DBObject}.");
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
            EList<JvmFormalParameter> _parameters = it.getParameters();
            JvmTypeReference _newTypeRef = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(bean, "com.mongodb.DBObject");
            JvmFormalParameter _parameter = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.toParameter(it, "dbObject", _newTypeRef);
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  it.append("this._dbObject = dbObject;");
                }
              };
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(bean, _function);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      EList<JvmMember> _members_1 = inferredType.getMembers();
      final Procedure1<JvmConstructor> _function_1 = new Procedure1<JvmConstructor>() {
          public void apply(final JvmConstructor it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Creates a new ");
            String _name = bean.getName();
            _builder.append(_name, "");
            _builder.append(" wrapping a new {@link BasicDBObject}.");
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
            EList<JvmFormalParameter> _parameters = it.getParameters();
            JvmTypeReference _newTypeRef = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(inferredType);
            JvmTypeReference _newTypeRef_1 = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(bean, "org.eclipse.xtext.xbase.lib.Procedures$Procedure1", _newTypeRef);
            JvmFormalParameter _parameter = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.toParameter(bean, "initializer", _newTypeRef_1);
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  it.append("_dbObject = new ");
                  JvmTypeReference _newTypeRef = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(bean, "com.mongodb.BasicDBObject");
                  MongoBeansJvmModelInferrer.this._typeReferenceSerializer.serialize(_newTypeRef, bean, it);
                  it.append("();\n");
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("_dbObject.put(JAVA_CLASS_KEY, \"");
                  String _identifier = inferredType.getIdentifier();
                  _builder.append(_identifier, "");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("initializer.apply(this);");
                  _builder.newLine();
                  it.append(_builder);
                }
              };
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmConstructor _constructor_1 = this._jvmTypesBuilder.toConstructor(bean, _function_1);
      boolean _add = this._jvmTypesBuilder.<JvmConstructor>operator_add(_members_1, _constructor_1);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  protected boolean addDbObjectProperty(final JvmDeclaredType inferredType, final MongoBean bean) {
    boolean _xblockexpression = false;
    {
      EList<JvmMember> _members = inferredType.getMembers();
      JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(bean, "com.mongodb.DBObject");
      JvmField _field = this._jvmTypesBuilder.toField(bean, "_dbObject", _newTypeRef);
      this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
      EList<JvmMember> _members_1 = inferredType.getMembers();
      JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(bean, "com.mongodb.DBObject");
      JvmOperation _getter = this._jvmTypesBuilder.toGetter(bean, "dBObject", "_dbObject", _newTypeRef_1);
      boolean _add = this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _getter);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  protected boolean addListAccessor(final JvmDeclaredType inferredType, final MongoProperty property) {
    boolean _xifexpression = false;
    JvmTypeReference _type = property.getType();
    boolean _isMongoPrimitiveType = this._mongoTypes.isMongoPrimitiveType(_type);
    if (_isMongoPrimitiveType) {
      EList<JvmMember> _members = inferredType.getMembers();
      String _name = property.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      String _plus = ("get" + _firstUpper);
      JvmTypeReference _type_1 = property.getType();
      JvmTypeReference _asWrapperTypeIfPrimitive = this._primitives.asWrapperTypeIfPrimitive(_type_1);
      JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(property, "java.util.List", _asWrapperTypeIfPrimitive);
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            String _documentation = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(property);
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  it.append("return (");
                  JvmTypeReference _type = property.getType();
                  JvmTypeReference _asWrapperTypeIfPrimitive = MongoBeansJvmModelInferrer.this._primitives.asWrapperTypeIfPrimitive(_type);
                  JvmTypeReference _newTypeRef = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(property, "java.util.List", _asWrapperTypeIfPrimitive);
                  MongoBeansJvmModelInferrer.this._typeReferenceSerializer.serialize(_newTypeRef, property, it);
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append(") _dbObject.get(\"");
                  String _name = property.getName();
                  _builder.append(_name, "");
                  _builder.append("\");");
                  it.append(_builder);
                }
              };
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(property, _plus, _newTypeRef, _function);
      boolean _add = this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      _xifexpression = _add;
    } else {
      boolean _xblockexpression = false;
      {
        EList<JvmMember> _members_1 = inferredType.getMembers();
        String _name_1 = property.getName();
        String _plus_1 = ("_" + _name_1);
        JvmTypeReference _type_2 = property.getType();
        JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(property, 
          "org.eclipse.xtext.mongobeans.DBObjectListWrapper", _type_2);
        JvmField _field = this._jvmTypesBuilder.toField(property, _plus_1, _newTypeRef_1);
        this._jvmTypesBuilder.<JvmField>operator_add(_members_1, _field);
        EList<JvmMember> _members_2 = inferredType.getMembers();
        String _name_2 = property.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
        String _plus_2 = ("get" + _firstUpper_1);
        JvmTypeReference _type_3 = property.getType();
        JvmTypeReference _newTypeRef_2 = this._jvmTypesBuilder.newTypeRef(property, "java.util.List", _type_3);
        final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
            public void apply(final JvmOperation it) {
              String _documentation = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(property);
              MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
              final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                  public void apply(final ITreeAppendable it) {
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("if(_");
                    String _name = property.getName();
                    _builder.append(_name, "");
                    _builder.append("==null)");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("_");
                    String _name_1 = property.getName();
                    _builder.append(_name_1, "	");
                    _builder.append(" = new ");
                    it.append(_builder);
                    JvmTypeReference _type = property.getType();
                    JvmTypeReference _newTypeRef = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(property, "org.eclipse.xtext.mongobeans.DBObjectListWrapper", _type);
                    MongoBeansJvmModelInferrer.this._typeReferenceSerializer.serialize(_newTypeRef, property, it);
                    String _name_2 = property.getName();
                    String _plus = ("(_dbObject, \"" + _name_2);
                    String _plus_1 = (_plus + "\");\n");
                    it.append(_plus_1);
                    String _name_3 = property.getName();
                    String _plus_2 = ("return _" + _name_3);
                    String _plus_3 = (_plus_2 + ";");
                    it.append(_plus_3);
                  }
                };
              MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
            }
          };
        JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(property, _plus_2, _newTypeRef_2, _function_1);
        boolean _add_1 = this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_1);
        _xblockexpression = (_add_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected boolean addDelegateAccessors(final JvmDeclaredType inferredType, final MongoProperty property) {
    boolean _xblockexpression = false;
    {
      EList<JvmMember> _members = inferredType.getMembers();
      String _name = property.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      String _plus = ("get" + _firstUpper);
      JvmTypeReference _type = property.getType();
      final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            String _documentation = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(property);
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  it.append("return (");
                  JvmTypeReference _type = property.getType();
                  JvmTypeReference _asWrapperTypeIfPrimitive = MongoBeansJvmModelInferrer.this._primitives.asWrapperTypeIfPrimitive(_type);
                  MongoBeansJvmModelInferrer.this._typeReferenceSerializer.serialize(_asWrapperTypeIfPrimitive, property, it);
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append(") _dbObject.get(\"");
                  String _name = property.getName();
                  _builder.append(_name, "");
                  _builder.append("\");");
                  it.append(_builder);
                }
              };
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(property, _plus, _type, _function);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      EList<JvmMember> _members_1 = inferredType.getMembers();
      String _name_1 = property.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
      String _plus_1 = ("set" + _firstUpper_1);
      final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            String _documentation = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(property);
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
            EList<JvmFormalParameter> _parameters = it.getParameters();
            String _name = property.getName();
            JvmTypeReference _type = property.getType();
            JvmFormalParameter _parameter = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.toParameter(it, _name, _type);
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
            final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append(" ");
                  _builder.append("_dbObject.put(\"");
                  String _name = property.getName();
                  _builder.append(_name, " ");
                  _builder.append("\", ");
                  String _name_1 = property.getName();
                  _builder.append(_name_1, " ");
                  _builder.append(");");
                  it.append(_builder);
                }
              };
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
          }
        };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(property, _plus_1, null, _function_1);
      boolean _add = this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  protected boolean addMethod(final JvmDeclaredType inferredType, final MongoOperation operation) {
    EList<JvmMember> _members = inferredType.getMembers();
    String _name = operation.getName();
    JvmTypeReference _returnType = operation.getReturnType();
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          String _documentation = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(operation);
          MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
          EList<JvmFormalParameter> _parameters = operation.getParameters();
          for (final JvmFormalParameter parameter : _parameters) {
            EList<JvmFormalParameter> _parameters_1 = it.getParameters();
            String _name = parameter.getName();
            JvmTypeReference _parameterType = parameter.getParameterType();
            JvmFormalParameter _parameter = MongoBeansJvmModelInferrer.this._jvmTypesBuilder.toParameter(parameter, _name, _parameterType);
            MongoBeansJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter);
          }
          XExpression _body = operation.getBody();
          MongoBeansJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _body);
        }
      };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(operation, _name, _returnType, _function);
    boolean _add = this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    return _add;
  }
  
  public void infer(final EObject bean, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (bean instanceof MongoBean) {
      _infer((MongoBean)bean, acceptor, isPreIndexingPhase);
      return;
    } else if (bean != null) {
      _infer(bean, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bean, acceptor, isPreIndexingPhase).toString());
    }
  }
}
