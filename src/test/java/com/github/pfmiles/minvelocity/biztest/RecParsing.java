/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.github.pfmiles.minvelocity.biztest;

import java.util.HashMap;
import java.util.Map;

import com.github.pfmiles.minvelocity.biztest.TemplateRenderUtil;

/**
 * 用于在velocity中执行带调用栈的递归渲染的辅助类，支持以“串接”形式添加参数
 * 
 * @author pf-miles 2014-4-15 下午5:20:34
 */
public class RecParsing {

    private Map<String, Object> ctx = new HashMap<String, Object>();
    private String              tempPath;

    public RecParsing(String tempPath){
        this.tempPath = tempPath;
    }

    public RecParsing addParam(String key, Object value) {
        ctx.put(key, value);
        return this;
    }

    public String toString() {
        return TemplateRenderUtil.render(tempPath, ctx);
    }

}
