/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
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
