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

import java.util.HashMap;
import java.util.Map;

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
        return TemplateUtil.render(tempPath, ctx);
    }

}
