/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.github.pfmiles.minvelocity.biztest;

/**
 * 实现一些业务方法，方便模板渲染时调用
 * 
 * @author pf-miles 2014-4-15 下午2:42:49
 */
public class BizUtil {

    /**
     * 支持带调用栈(即每层递归调用的context彼此隔离)的parse,
     * 当需要在递归parse过程中保持调用栈时可用于代替velocity中原本的#parse directive
     */
    public static RecParsing recParsing(String tempPath) {
        return new RecParsing(tempPath);
    }
}
