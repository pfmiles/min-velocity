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
