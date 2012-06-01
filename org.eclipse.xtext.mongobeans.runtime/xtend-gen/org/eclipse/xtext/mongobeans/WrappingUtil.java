package org.eclipse.xtext.mongobeans;

import com.mongodb.DBObject;
import java.lang.reflect.Constructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class WrappingUtil {
  public static IDBObjectWrapper wrap(final DBObject dbObject) {
    try {
      IDBObjectWrapper _xblockexpression = null;
      {
        Object _get = dbObject.get(IDBObjectWrapper.JAVA_CLASS_KEY);
        final String javaClassName = _get==null?(String)null:_get.toString();
        ClassLoader _classLoader = WrappingUtil.class.getClassLoader();
        final Class<? extends Object> javaClass = _classLoader.loadClass(javaClassName);
        IDBObjectWrapper _xifexpression = null;
        boolean _isAssignableFrom = IDBObjectWrapper.class.isAssignableFrom(javaClass);
        if (_isAssignableFrom) {
          IDBObjectWrapper _xblockexpression_1 = null;
          {
            final Constructor<? extends Object> constructor = javaClass.getConstructor(DBObject.class);
            Object _newInstance = constructor.newInstance(dbObject);
            _xblockexpression_1 = (((IDBObjectWrapper) _newInstance));
          }
          _xifexpression = _xblockexpression_1;
        } else {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Stored javaClass \'");
          _builder.append(javaClassName, "");
          _builder.append("\' does not extend \'");
          String _simpleName = IDBObjectWrapper.class.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append("\'");
          IllegalStateException _illegalStateException = new IllegalStateException(_builder.toString());
          throw _illegalStateException;
        }
        _xblockexpression = (_xifexpression);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static <T extends Object> T wrapAndCast(final DBObject dbObject) {
    IDBObjectWrapper _wrap = WrappingUtil.wrap(dbObject);
    return ((T) _wrap);
  }
  
  public static DBObject unwrap(final Object wrapper) {
    DBObject _xifexpression = null;
    boolean _not = (!(wrapper instanceof IDBObjectWrapper));
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Invalid type");
      throw _illegalArgumentException;
    } else {
      DBObject _dbObject = ((IDBObjectWrapper) wrapper).getDbObject();
      _xifexpression = _dbObject;
    }
    return _xifexpression;
  }
}
