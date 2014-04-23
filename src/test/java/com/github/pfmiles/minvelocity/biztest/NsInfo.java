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

import java.util.List;

/**
 * namespace信息，包含其下所有的api信息
 * 
 * @author pf-miles 2014-4-10 下午5:05:37
 */
public class NsInfo {

    // 命名空间名
    private String        nsName;
    // 生成命名空间的Interface类名
    private String        nsInterfaceName;
    // 对应其下所有api信息
    private List<ApiInfo> apiInfos;

    public String getNsName() {
        return nsName;
    }

    /**
     * 设置命名空间名，如"cn.alibaba.open"
     */
    public void setNsName(String nsName) {
        this.nsName = nsName;
    }

    public String getNsInterfaceName() {
        return nsInterfaceName;
    }

    /**
     * 设置命名空间生成的类名，需要符合java类名规范，如"CnAlibabaOpen"，此类将作为ApiFacade的内部类出现, 用于归类api方法
     */
    public void setNsInterfaceName(String nsInterfaceName) {
        this.nsInterfaceName = nsInterfaceName;
    }

    public List<ApiInfo> getApiInfos() {
        return apiInfos;
    }

    /**
     * 设置该ns对应的其下所有打算自动生成调用方法的api的信息
     */
    public void setApiInfos(List<ApiInfo> apiInfos) {
        this.apiInfos = apiInfos;
    }

}
