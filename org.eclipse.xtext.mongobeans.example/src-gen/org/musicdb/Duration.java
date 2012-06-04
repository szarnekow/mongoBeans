package org.musicdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.List;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class Duration implements IDBObjectWrapper {
  /**
   * Creates a new Duration wrapping the given {@link DBObject}.
   */
  public Duration(final DBObject dbObject) {
    this._dbObject = dbObject;
  }
  
  /**
   * Creates a new Duration wrapping a new {@link BasicDBObject}.
   */
  public Duration() {
    _dbObject = new BasicDBObject();
    _dbObject.put(JAVA_CLASS_KEY, "org.musicdb.Duration");
    
  }
  
  /**
   * Creates a new Duration wrapping a new {@link BasicDBObject} with an Xtend friendly constructor.
   */
  public Duration(final Procedure1<Duration> initializer) {
    this();
    initializer.apply(this);
    
  }
  
  private DBObject _dbObject;
  
  public DBObject getDbObject() {
    return this._dbObject;
  }
  
  public int getSeconds() {
    return (Integer) _dbObject.get("seconds");
  }
  
  public void setSeconds(final int seconds) {
     _dbObject.put("seconds", seconds);
  }
  
  public void fromString(final String duration) {
    final String[] split = duration.split(":");
    String _get = ((List<String>)Conversions.doWrapArray(split)).get(0);
    int _parseInt = Integer.parseInt(_get);
    int _multiply = (_parseInt * 60);
    String _get_1 = ((List<String>)Conversions.doWrapArray(split)).get(1);
    int _parseInt_1 = Integer.parseInt(_get_1);
    int _plus = (_multiply + _parseInt_1);
    this.setSeconds(_plus);
  }
  
  public String toString() {
    int _seconds = this.getSeconds();
    int _divide = (_seconds / 60);
    String _string = Integer.toString(_divide);
    String _plus = (_string + ":");
    int _seconds_1 = this.getSeconds();
    int _modulo = (_seconds_1 % 60);
    String _string_1 = Integer.toString(_modulo);
    String _plus_1 = (_plus + _string_1);
    return _plus_1;
  }
  
  public Duration operator_plus(final Duration other) {
    final Procedure1<Duration> _function = new Procedure1<Duration>() {
        public void apply(final Duration it) {
          int _seconds = Duration.this.getSeconds();
          int _seconds_1 = other.getSeconds();
          int _plus = (_seconds + _seconds_1);
          it.setSeconds(_plus);
        }
      };
    Duration _duration = new Duration(_function);
    return _duration;
  }
}
