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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

import org.apache.commons.lang.StringUtils;

public class JavaSourceFile extends SimpleJavaFileObject {

    private String fileName;
    private String code;

    /**
     * 创建内存java源码文件
     * 
     * @param fileName 文件名
     * @param pkg 包名
     * @param code 代码
     */
    public JavaSourceFile(String fileName, String pkg, String code){
        super(genMemFileUri(fileName, pkg), Kind.SOURCE);
        this.fileName = fileName;
        this.code = code;
    }

    private static URI genMemFileUri(String fileName, String pkg) {
        String pkgPath = "";
        if (StringUtils.isNotBlank(pkg)) pkgPath = pkg.replaceAll("\\.", "/") + "/";
        return URI.create("mem:///src/" + pkgPath + fileName);
    }

    public String getName() {
        return this.fileName;
    }

    public InputStream openInputStream() throws IOException {
        return new ByteArrayInputStream(this.code.getBytes());
    }

    public OutputStream openOutputStream() throws IOException {
        throw new UnsupportedOperationException();
    }

    public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
        return new BufferedReader(new InputStreamReader(this.openInputStream()));
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return this.code;
    }

    public Writer openWriter() throws IOException {
        throw new UnsupportedOperationException();
    }

    public boolean delete() {
        throw new UnsupportedOperationException();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return uri.toString();
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uri == null) ? 0 : uri.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        JavaSourceFile other = (JavaSourceFile) obj;
        if (uri == null) {
            if (other.toUri() != null) return false;
        } else if (!uri.equals(other.toUri())) return false;
        return true;
    }
}
