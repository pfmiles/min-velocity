package com.github.pfmiles.minvelocity;

import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.List;

import com.github.pfmiles.org.apache.velocity.runtime.log.Log;

/**
 * 忽略IndexOutOfBoundsException的list实现
 * 
 * @author pf-miles
 * 
 */
public class IndexOutOfBoundsIgnoringList extends AbstractList<Object> {

    public static Method getMethod;
    public static Method setMethod;

    static {
        try {
            getMethod = IndexOutOfBoundsIgnoringList.class.getMethod("get", int.class);
            getMethod.setAccessible(true);
            setMethod = IndexOutOfBoundsIgnoringList.class.getMethod("set", int.class, Object.class);
            setMethod.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Object> wrappingList;
    private Log log;

    public IndexOutOfBoundsIgnoringList(Object o, Log log) {
        if (!(o instanceof List))
            throw new IllegalArgumentException("Wrapping object is not a List, impossible!");
        this.wrappingList = (List<Object>) o;
        this.log = log;
    }

    public Object get(int index) {
        try {
            return this.wrappingList.get(index);
        } catch (IndexOutOfBoundsException e) {
            log.info("Index out of bounds when rendering template while accessing list's elements, suppressed.");
            return null;
        }
    }

    public Object set(int index, Object element) {
        try {
            return this.wrappingList.set(index, element);
        } catch (IndexOutOfBoundsException e) {
            log.info("Index out of bounds when rendering template while setting list's elements, suppressed.");
            return null;
        }
    }

    public int size() {
        return this.wrappingList.size();
    }

}
