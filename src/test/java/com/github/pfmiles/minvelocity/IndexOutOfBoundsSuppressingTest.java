package com.github.pfmiles.minvelocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

/**
 * @author pf-miles
 * 
 */
public class IndexOutOfBoundsSuppressingTest extends TestCase {
    public void testSuppressing() {
        Map<String, Object> ctxPojo = new HashMap<String, Object>();
        ctxPojo.put("arr", new String[] { "test" });
        List<String> list = new ArrayList<String>();
        list.add("hello");
        ctxPojo.put("list", list);
        StringWriter out = new StringWriter();
        TemplateUtil.renderString("$arr[1] $arr.get(1) $list[1] $list.get(1)", ctxPojo, out);
        // System.out.println(out.toString());
        assertTrue("$arr[1] $arr.get(1) $list[1] $list.get(1)".equals(out.toString()));
        out = new StringWriter();
        TemplateUtil.renderString("$arr[0] $arr.get(0) $list[0] $list.get(0)", ctxPojo, out);
        // System.out.println(out.toString());
        assertTrue("test test hello hello".equals(out.toString()));

        // setting tests
        out = new StringWriter();
        TemplateUtil.renderString("$arr.set(1, 'test1') $list.set(1, 'hello1')", ctxPojo, out);
        // System.out.println(out.toString());
        assertTrue("$arr.set(1, 'test1') $list.set(1, 'hello1')".equals(out.toString()));

        out = new StringWriter();
        TemplateUtil.renderString("$arr.set(0, 'test1') $list.set(0, 'hello1') $arr[0] $list[0]", ctxPojo, out);
        // System.out.println(out.toString());
        assertTrue("test hello test1 hello1".equals(out.toString()));
    }
}
