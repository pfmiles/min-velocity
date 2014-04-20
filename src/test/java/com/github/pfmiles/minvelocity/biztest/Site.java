/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.github.pfmiles.minvelocity.biztest;

/**
 * 区分不同的ocean部署站点、逻辑集群的枚举；由其管理一些与部署集群相关的渲染属性
 * 
 * @author pf-miles 2014-4-10 下午4:01:08
 */
public enum Site {

    CBU() {

        public String getBasePkgName() {
            return "com.alibaba.china.openapi.client.biz";
        }

        public String getMainClsName() {
            return "CnApiFacade";
        }

        public String getServerHost() {
            return "gw.open.1688.com";
        }
    },
    ICBU {

        public String getBasePkgName() {
            return "com.alibaba.intl.openapi.client.biz";
        }

        public String getMainClsName() {
            return "IntlApiFacade";
        }

        public String getServerHost() {
            return "gw.api.alibaba.com";
        }
    };

    /**
     * 取得生成的业务sdk的包名前缀
     */
    public String getBasePkgName() {
        throw new UnsupportedOperationException("Velocity trick!");
    }

    /**
     * 决定生成的sdk的主入口类的类名
     */
    public String getMainClsName() {
        throw new UnsupportedOperationException("Velocity trick!");
    }

    /**
     * 决定默认访问的gateway host
     */
    public String getServerHost() {
        throw new UnsupportedOperationException("Velocity trick!");
    }
}
