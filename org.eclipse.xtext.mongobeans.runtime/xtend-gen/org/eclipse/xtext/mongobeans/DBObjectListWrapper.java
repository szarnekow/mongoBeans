package org.eclipse.xtext.mongobeans;

import com.google.common.base.Objects;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.mongobeans.WrappingUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class DBObjectListWrapper<T extends Object> implements List<T> {
  private List<DBObject> delegate;
  
  public DBObjectListWrapper(final DBObject owner, final String key) {
    final Object value = owner.get(key);
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      ArrayList<DBObject> _newArrayList = CollectionLiterals.<DBObject>newArrayList();
      this.delegate = _newArrayList;
      owner.put(key, this.delegate);
    } else {
      this.delegate = ((List<DBObject>) value);
    }
  }
  
  public int size() {
    int _size = this.delegate.size();
    return _size;
  }
  
  public boolean isEmpty() {
    boolean _isEmpty = this.delegate.isEmpty();
    return _isEmpty;
  }
  
  public boolean contains(final Object o) {
    DBObject _unwrap = WrappingUtil.unwrap(o);
    boolean _contains = this.delegate.contains(_unwrap);
    return _contains;
  }
  
  public Iterator<T> iterator() {
    final Function1<DBObject,T> _function = new Function1<DBObject,T>() {
        public T apply(final DBObject it) {
          T _wrapAndCast = WrappingUtil.<T>wrapAndCast(it);
          return _wrapAndCast;
        }
      };
    List _map = ListExtensions.<DBObject, T>map(this.delegate, _function);
    Iterator _iterator = _map.iterator();
    return _iterator;
  }
  
  public T[] toArray() {
    final Function1<DBObject,IDBObjectWrapper> _function = new Function1<DBObject,IDBObjectWrapper>() {
        public IDBObjectWrapper apply(final DBObject it) {
          IDBObjectWrapper _wrap = WrappingUtil.wrap(it);
          return _wrap;
        }
      };
    List _map = ListExtensions.<DBObject, IDBObjectWrapper>map(this.delegate, _function);
    Object[] _array = _map.toArray();
    return ((T[]) _array);
  }
  
  public <T extends Object> T[] toArray(final T[] a) {
    T[] _xblockexpression = null;
    {
      final Function1<DBObject,T> _function = new Function1<DBObject,T>() {
          public T apply(final DBObject it) {
            T _wrapAndCast = WrappingUtil.<T>wrapAndCast(it);
            return _wrapAndCast;
          }
        };
      final List<T> casted = ListExtensions.<DBObject, T>map(this.delegate, _function);
      T[] _array = casted.<T>toArray(a);
      _xblockexpression = (((T[]) _array));
    }
    return _xblockexpression;
  }
  
  public boolean add(final T e) {
    DBObject _unwrap = WrappingUtil.unwrap(e);
    boolean _add = this.delegate.add(_unwrap);
    return _add;
  }
  
  public boolean remove(final Object o) {
    DBObject _unwrap = WrappingUtil.unwrap(o);
    boolean _remove = this.delegate.remove(_unwrap);
    return _remove;
  }
  
  public boolean containsAll(final Collection<? extends Object> c) {
    final Function1<Object,DBObject> _function = new Function1<Object,DBObject>() {
        public DBObject apply(final Object it) {
          DBObject _unwrap = WrappingUtil.unwrap(it);
          return _unwrap;
        }
      };
    Iterable<DBObject> _map = IterableExtensions.map(c, _function);
    List<DBObject> _list = IterableExtensions.<DBObject>toList(_map);
    boolean _containsAll = this.delegate.containsAll(_list);
    return _containsAll;
  }
  
  public boolean addAll(final Collection<? extends T> c) {
    boolean _xblockexpression = false;
    {
      for (final T element : c) {
        DBObject _unwrap = WrappingUtil.unwrap(element);
        this.delegate.add(_unwrap);
      }
      boolean _isEmpty = c.isEmpty();
      boolean _not = (!_isEmpty);
      _xblockexpression = (_not);
    }
    return _xblockexpression;
  }
  
  public boolean addAll(final int index, final Collection<? extends T> c) {
    boolean _xblockexpression = false;
    {
      List<?> _list = IterableExtensions.toList(c);
      List<T> _reverse = ListExtensions.<T>reverse(((List<T>) _list));
      final Function1<T,DBObject> _function = new Function1<T,DBObject>() {
          public DBObject apply(final T it) {
            DBObject _unwrap = WrappingUtil.unwrap(it);
            return _unwrap;
          }
        };
      List _map = ListExtensions.<T, DBObject>map(_reverse, _function);
      for (final DBObject element : ((List<DBObject>) _map)) {
        this.delegate.add(index, element);
      }
      boolean _isEmpty = c.isEmpty();
      boolean _not = (!_isEmpty);
      _xblockexpression = (_not);
    }
    return _xblockexpression;
  }
  
  public boolean removeAll(final Collection<? extends Object> c) {
    final Function1<Object,DBObject> _function = new Function1<Object,DBObject>() {
        public DBObject apply(final Object it) {
          DBObject _unwrap = WrappingUtil.unwrap(it);
          return _unwrap;
        }
      };
    Iterable<DBObject> _map = IterableExtensions.map(c, _function);
    List<DBObject> _list = IterableExtensions.<DBObject>toList(_map);
    boolean _removeAll = this.delegate.removeAll(_list);
    return _removeAll;
  }
  
  public boolean retainAll(final Collection<? extends Object> c) {
    final Function1<Object,DBObject> _function = new Function1<Object,DBObject>() {
        public DBObject apply(final Object it) {
          DBObject _unwrap = WrappingUtil.unwrap(it);
          return _unwrap;
        }
      };
    Iterable<DBObject> _map = IterableExtensions.map(c, _function);
    List<DBObject> _list = IterableExtensions.<DBObject>toList(_map);
    boolean _retainAll = this.delegate.retainAll(_list);
    return _retainAll;
  }
  
  public void clear() {
    this.delegate.clear();
  }
  
  public boolean equals(final Object o) {
    boolean _equals = this.delegate.equals(o);
    return _equals;
  }
  
  public int hashCode() {
    int _hashCode = this.delegate.hashCode();
    return _hashCode;
  }
  
  public T get(final int index) {
    DBObject _get = this.delegate.get(index);
    T _wrapAndCast = WrappingUtil.<T>wrapAndCast(_get);
    return _wrapAndCast;
  }
  
  public T set(final int index, final T element) {
    DBObject _unwrap = WrappingUtil.unwrap(element);
    DBObject _set = this.delegate.set(index, _unwrap);
    T _wrapAndCast = WrappingUtil.<T>wrapAndCast(_set);
    return _wrapAndCast;
  }
  
  public void add(final int index, final T element) {
    DBObject _unwrap = WrappingUtil.unwrap(element);
    this.delegate.add(index, _unwrap);
  }
  
  public T remove(final int index) {
    DBObject _remove = this.delegate.remove(index);
    T _wrapAndCast = WrappingUtil.<T>wrapAndCast(_remove);
    return _wrapAndCast;
  }
  
  public int indexOf(final Object o) {
    int _indexOf = this.delegate.indexOf(o);
    return _indexOf;
  }
  
  public int lastIndexOf(final Object o) {
    int _lastIndexOf = this.delegate.lastIndexOf(o);
    return _lastIndexOf;
  }
  
  public ListIterator<T> listIterator() {
    final Function1<DBObject,T> _function = new Function1<DBObject,T>() {
        public T apply(final DBObject it) {
          T _wrapAndCast = WrappingUtil.<T>wrapAndCast(it);
          return _wrapAndCast;
        }
      };
    List _map = ListExtensions.<DBObject, T>map(this.delegate, _function);
    ListIterator _listIterator = _map.listIterator();
    return _listIterator;
  }
  
  public ListIterator<T> listIterator(final int index) {
    final Function1<DBObject,T> _function = new Function1<DBObject,T>() {
        public T apply(final DBObject it) {
          T _wrapAndCast = WrappingUtil.<T>wrapAndCast(it);
          return _wrapAndCast;
        }
      };
    List _map = ListExtensions.<DBObject, T>map(this.delegate, _function);
    ListIterator _listIterator = _map.listIterator(index);
    return _listIterator;
  }
  
  public List<T> subList(final int fromIndex, final int toIndex) {
    final Function1<DBObject,T> _function = new Function1<DBObject,T>() {
        public T apply(final DBObject it) {
          T _wrapAndCast = WrappingUtil.<T>wrapAndCast(it);
          return _wrapAndCast;
        }
      };
    List _map = ListExtensions.<DBObject, T>map(this.delegate, _function);
    List _subList = _map.subList(fromIndex, toIndex);
    return _subList;
  }
}
