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
package com.github.pfmiles.minvelocity;

/**
 * 默认被加载到context中，辅助模板解析的工具类
 * 
 * @author pf-miles
 * 
 */
public class ParseUtil {

    /**
     * 支持带调用栈(即每层递归调用的context彼此隔离)的parse,
     * 当需要在递归parse过程中保持调用栈时可用于代替velocity中原本的#parse directive
     */
    public static RecParsing recParsing(String tempPath, String basePath) {
        if (tempPath.startsWith("/")) {
            return new RecParsing(tempPath);
        } else {
            return new RecParsing(ImplHelper.resolveAbsName(tempPath, basePath));
        }
    }
}
