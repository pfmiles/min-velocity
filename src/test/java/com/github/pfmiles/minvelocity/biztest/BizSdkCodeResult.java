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
