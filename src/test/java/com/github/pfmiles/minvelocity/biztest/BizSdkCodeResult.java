/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.github.pfmiles.minvelocity.biztest;

import java.util.List;


/**
 * 业务sdk生成结果，包含生成的java源码，可被直接送入FlyingCompileUtil进行编译
 * 
 * @author pf-miles 2014-4-10 下午4:49:11
 */
public class BizSdkCodeResult {

    // 业务SDK主入口类源码
    private JavaSourceFile       apiFacadeSrc;
    // 所有api参数类的源码
    private List<JavaSourceFile> paramPojosSrc;
    // 所有api结果类的源码
    private List<JavaSourceFile> resultPojosSrc;

    public JavaSourceFile getApiFacadeSrc() {
        return apiFacadeSrc;
    }

    public void setApiFacadeSrc(JavaSourceFile apiFacadeSrc) {
        this.apiFacadeSrc = apiFacadeSrc;
    }

    public List<JavaSourceFile> getParamPojosSrc() {
        return paramPojosSrc;
    }

    public void setParamPojosSrc(List<JavaSourceFile> paramPojosSrc) {
        this.paramPojosSrc = paramPojosSrc;
    }

    public List<JavaSourceFile> getResultPojosSrc() {
        return resultPojosSrc;
    }

    public void setResultPojosSrc(List<JavaSourceFile> resultPojosSrc) {
        this.resultPojosSrc = resultPojosSrc;
    }

}
