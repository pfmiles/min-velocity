/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.github.pfmiles.minvelocity.biztest;

import java.util.Map;

/**
 * 单个api的渲染属性
 * 
 * @author pf-miles 2014-4-10 下午5:08:58
 */
public class ApiInfo {

    // api说明
    private String                doc;
    // 生成的api方法名
    private String                methodName;
    // api参数类信息: name -> type
    private Map<String, Class<?>> paramInfo;
    // api结果类信息: name -> type, 或 name -> DeepAttrInfo
    private Map<String, Object>   resultInfo;
    // 是否需要用户授权
    private boolean               needAuthorization;
    // 是否需要传时间戳
    private boolean               needTimeStamp;
    // 是否需要https访问
    private boolean               needHttps;
    // 是否需要请求签名
    private boolean               needSignature;
    // 是否api通道限制的api
    private boolean               innerApi;
    // api名称
    private String                apiName;
    // api版本
    private int                   apiVer;
    // 结果映射表达式
    private String                resultLocatingExpr;

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Map<String, Class<?>> getParamInfo() {
        return paramInfo;
    }

    public void setParamInfo(Map<String, Class<?>> paramInfo) {
        this.paramInfo = paramInfo;
    }

    public Map<String, Object> getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(Map<String, Object> resultInfo) {
        this.resultInfo = resultInfo;
    }

    public boolean isNeedAuthorization() {
        return needAuthorization;
    }

    public void setNeedAuthorization(boolean needAuthorization) {
        this.needAuthorization = needAuthorization;
    }

    public boolean isNeedTimeStamp() {
        return needTimeStamp;
    }

    public void setNeedTimeStamp(boolean needTimeStamp) {
        this.needTimeStamp = needTimeStamp;
    }

    public boolean isNeedHttps() {
        return needHttps;
    }

    public void setNeedHttps(boolean needHttps) {
        this.needHttps = needHttps;
    }

    public boolean isNeedSignature() {
        return needSignature;
    }

    public void setNeedSignature(boolean needSignature) {
        this.needSignature = needSignature;
    }

    public boolean isInnerApi() {
        return innerApi;
    }

    public void setInnerApi(boolean innerApi) {
        this.innerApi = innerApi;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public int getApiVer() {
        return apiVer;
    }

    public void setApiVer(int apiVer) {
        this.apiVer = apiVer;
    }

    public String getResultLocatingExpr() {
        return resultLocatingExpr;
    }

    public void setResultLocatingExpr(String resultLocatingExpr) {
        this.resultLocatingExpr = resultLocatingExpr;
    }

}
