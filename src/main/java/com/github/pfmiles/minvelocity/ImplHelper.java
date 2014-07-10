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

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import com.github.pfmiles.org.apache.velocity.runtime.RuntimeConstants;

/**
 * @author pf-miles
 * 
 */
public class ImplHelper {

    // 根据相对路径(name)和当前路径(curPath, 绝对路径形式)，算出name对应的绝对路径
    public static String resolveAbsName(String name, String curPath) {
        ArrayList<String> relPath = toPathList(name);
        ArrayList<String> base = toPathList(curPath);
        base.remove(base.size() - 1);// to dir path
        for (String p : relPath) {
            if (".".equals(p)) {
                continue;
            } else if ("..".equals(p)) {
                base.remove(base.size() - 1);
            } else {
                base.add(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String b : base) {
            sb.append("/").append(b);
        }
        return sb.toString();
    }

    public static ArrayList<String> toPathList(String path) {
        String[] ss = path.split("/");
        ArrayList<String> ret = new ArrayList<String>();
        for (String s : ss) {
            if (s != null && !"".equals(s))
                ret.add(s);
        }
        return ret;
    }

    /**
     * 取得目前可用的classloader，用于动态加载资源
     */
    public static ClassLoader getCurrentClsLoader() {
        ClassLoader ctxLoader = Thread.currentThread().getContextClassLoader();
        if (ctxLoader != null) {
            try {
                ctxLoader.loadClass(ImplHelper.class.getName());
                return ctxLoader;
            } catch (ClassNotFoundException e) {
            }
        }
        return ImplHelper.class.getClassLoader();
    }

    /**
     * 将数据从from中，以bufferSize个字符为缓冲，“流”入to中，并关闭from; 可对总的读取字符数做限制
     * 
     * @param from
     *            数据源 into array
     * @param to
     *            目的地
     * @param bufferSize
     *            缓冲大小
     * @param totalSize
     *            总读取字符数限制
     * @throws IOException
     */
    public static void flowing(Reader from, Writer to, int bufferSize, int totalSize) throws IOException {
        if (bufferSize < 1)
            bufferSize = RuntimeConstants.DEFAULT_REFERENCE_RENDERING_BUFFER_SIZE;
        if (totalSize < 1)
            totalSize = RuntimeConstants.DEFAULT_REFERENCE_RENDERING_LIMIT;
        char[] buffer = new char[bufferSize];
        int read = 0;
        for (int i = from.read(buffer); i != -1; i = from.read(buffer)) {
            to.write(buffer, 0, i);
            read += i;
            if (read >= totalSize)
                break;
        }
        from.close();
    }
}
