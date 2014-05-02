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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class DirectiveTest extends TestCase {

    public void testForEach() {
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        param.put("list", list);
        String rst = TemplateUtil.render("test/foreach.vm", param);
        assertTrue("one\ntwo\nthree\n".equals(rst));
    }

    public void testInclude() {
        String rst = TemplateUtil.render("test/include.vm", null);
        assertTrue("Not Included\nIncluded\nNot Included".equals(rst));
    }

    public void testParse() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Miles");
        String rst = TemplateUtil.render("test/parse.vm", params);
        assertTrue("My name is Miles!".equals(rst));
    }

    public void testRecParse() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("num", 5);
        String rst = TemplateUtil.render("/test/recParse.vm", params);
        assertTrue("5!\n4!\n3!\n2!\n1!\nend!".equals(rst.trim()));
    }

    public void testLiteral() {
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        param.put("boogie", list);
        String rst = TemplateUtil.render("test/literal.vm", param);
        assertTrue("#foreach ($woogie in $boogie)\n    nothing will happen to $woogie\n#end".equals(rst.trim()));
    }

    // temp -> #parse -> ParseUtil -> #parse -> ParseUtil
    public void testParseRecUtilParseRecUtil() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hello", "world");
        String rst = TemplateUtil.render("/test/parseRecUtils.vm", params);
        assertTrue("world\nworld\nworld\nworld".equals(rst.trim()));
    }

}
