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
        String rst = TemplateRenderUtil.render("test/foreach.vm", param);
        assertTrue("one\ntwo\nthree\n".equals(rst));
    }

    public void testInclude() {
        String rst = TemplateRenderUtil.render("test/include.vm", null);
        assertTrue("Not Included\nIncluded\nNot Included".equals(rst));
    }

    public void testParse() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Miles");
        String rst = TemplateRenderUtil.render("test/parse.vm", params);
        assertTrue("My name is Miles!".equals(rst));
    }

    public void testRecParse() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("num", 5);
        String rst = TemplateRenderUtil.render("test/recParse.vm", params);
        assertTrue("5!\n4!\n3!\n2!\n1!\nend!".equals(rst.trim()));
    }

    public void testLiteral() {
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        param.put("boogie", list);
        String rst = TemplateRenderUtil.render("test/literal.vm", param);
        assertTrue("#foreach ($woogie in $boogie)\n    nothing will happen to $woogie\n#end".equals(rst.trim()));
    }

}
