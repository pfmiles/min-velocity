package com.github.pfmiles.minvelocity;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.github.pfmiles.org.apache.velocity.Template;

public class TemplateUtilTest extends TestCase {

    public void testRenderStringTemp() {
        String templateString = "#foreach($i in $list)\n$i\n#end";
        Map<String, Object> ctxPojo = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        ctxPojo.put("list", list);
        StringWriter out = new StringWriter();
        TemplateUtil.renderString(templateString, ctxPojo, out);
        // System.out.println(out.toString());
        assertTrue("one\ntwo\nthree\n".equals(out.toString()));
    }

    public void testRenderTemplate() {
        Template temp = TemplateUtil.parseStringTemplate("#foreach($i in $list)\n$i\n#end");
        Map<String, Object> ctxPojo = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        ctxPojo.put("list", list);
        StringWriter out = new StringWriter();
        TemplateUtil.renderTemplate(temp, ctxPojo, out);
        // System.out.println(out.toString());
        assertTrue("one\ntwo\nthree\n".equals(out.toString()));
    }

    public void testRefRendering() {
        Template temp = TemplateUtil.parseStringTemplate("hello $ref world");
        Map<String, Object> ctxPojo = new HashMap<String, Object>();
        StringReader stream = new StringReader("1234567890");
        ctxPojo.put("ref", stream);
        StringWriter writer = new StringWriter();
        TemplateUtil.renderTemplate(temp, ctxPojo, writer);
        assertTrue("hello 1234567890 world".equals(writer.toString()));
    }
}