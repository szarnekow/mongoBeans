package org.eclipse.xtext.mongobeans.jvmmodel;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Set;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class MongoTypes {
  @Inject
  private SuperTypeCollector _superTypeCollector;
  
  private final ArrayList<String> mongoPrimitiveTypes = new Function0<ArrayList<String>>() {
    public ArrayList<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(
        "double", 
        "java.lang.Double", 
        "java.lang.String", 
        "byte[]", 
        "boolean", 
        "java.lang.Boolean", 
        "java.util.Date", 
        "void", 
        "java.lang.Void", 
        "java.util.regex.Pattern", 
        "int", 
        "java.lang.Integer", 
        "long", 
        "java.lang.Long");
      return _newArrayList;
    }
  }.apply();
  
  public boolean isMongoPrimitiveType(final JvmTypeReference typeRef) {
    String _qualifiedName = typeRef.getQualifiedName();
    boolean _contains = this.mongoPrimitiveTypes.contains(_qualifiedName);
    return _contains;
  }
  
  public boolean isMongoType(final JvmTypeReference typeRef) {
    boolean _or = false;
    boolean _isMongoPrimitiveType = this.isMongoPrimitiveType(typeRef);
    if (_isMongoPrimitiveType) {
      _or = true;
    } else {
      Set<String> _collectSuperTypeNames = this._superTypeCollector.collectSuperTypeNames(typeRef);
      boolean _contains = _collectSuperTypeNames.contains("org.eclipse.xtext.mongobeans.IDBObjectWrapper");
      _or = (_isMongoPrimitiveType || _contains);
    }
    return _or;
  }
}
