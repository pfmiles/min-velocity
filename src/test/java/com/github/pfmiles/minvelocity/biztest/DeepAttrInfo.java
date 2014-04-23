/*******************************************************************************
 * Copyright 2014 pf-miles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.github.pfmiles.minvelocity.biztest;

import java.util.HashMap;

/**
 * result类中，嵌套复杂属性的meta信息，继承自HashMap，map中的entry为bean属性的name -> type对，另外，本类还包含该嵌套result复杂属性的对应类名可供设置; 本类可递归嵌套
 * 
 * @author pf-miles 2014-4-15 下午3:02:55
 */
public class DeepAttrInfo extends HashMap<String, Object> {

    private static final long serialVersionUID = 6376677794286307662L;

    // result嵌套复杂属性的类名
    private String            attClsName;

    public String getAttClsName() {
        return attClsName;
    }

    public void setAttClsName(String attClsName) {
        this.attClsName = attClsName;
    }

}
