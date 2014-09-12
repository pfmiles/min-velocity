package com.github.pfmiles.org.apache.velocity.util;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.lang.reflect.Array;
import java.util.AbstractList;

import com.github.pfmiles.org.apache.velocity.runtime.RuntimeConstants;
import com.github.pfmiles.org.apache.velocity.runtime.RuntimeServices;
import com.github.pfmiles.org.apache.velocity.runtime.log.Log;

/**
 * A class that wraps an array with a List interface.
 * 
 * @author Chris Schultz &lt;chris@christopherschultz.net$gt;
 * @author pf-miles
 */
public class ArrayListWrapper extends AbstractList {
    private Object array;
    private Log log;
    private RuntimeServices runtimeServices;

    public ArrayListWrapper(Object array, Log log, RuntimeServices rs) {
        this.array = array;
        this.log = log;
        this.runtimeServices = rs;
    }

    public Object get(int index) {
        boolean supressExp = this.runtimeServices.getBoolean(RuntimeConstants.SUPPRESS_INDEX_OUT_OF_BOUNDS_EXCEPTION, false);
        if (supressExp) {
            try {
                return Array.get(array, index);
            } catch (NullPointerException e) {
                log.info("Null array encountered when rendering template while accessing its elements, suppressed.");
                return null;
            } catch (ArrayIndexOutOfBoundsException e) {
                log.info("Array index out of bounds when rendering template while accessing its elements, suppressed.");
                return null;
            }
        } else {
            return Array.get(array, index);
        }
    }

    public Object set(int index, Object element) {
        boolean supressExp = this.runtimeServices.getBoolean(RuntimeConstants.SUPPRESS_INDEX_OUT_OF_BOUNDS_EXCEPTION, false);
        if (supressExp) {
            Object old = get(index);
            try {
                Array.set(array, index, element);
            } catch (NullPointerException e) {
                log.info("Null array encountered when rendering template while setting its elements, suppressed.");
                return null;
            } catch (ArrayIndexOutOfBoundsException e) {
                log.info("Array index out of bounds when rendering template while setting its elements, suppressed.");
                return null;
            }
            return old;
        } else {
            Object old = get(index);
            Array.set(array, index, element);
            return old;
        }
    }

    public int size() {
        return Array.getLength(array);
    }

}
