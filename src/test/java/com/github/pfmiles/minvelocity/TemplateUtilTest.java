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

    private static final class 中文类 {
        public String[] 中文数组;

        public 中文类() {
            this.中文数组 = new String[] { "^_^" };
        }

        public String[] 获取中文数组() {
            return this.中文数组;
        }

        public String[] get中文数组() {
            return this.中文数组;
        }
    }

    public void testChineseRefRendering() {
        Template temp = TemplateUtil.parseStringTemplate("hello $温悦 ${张玮玮} world");
        Map<String, Object> ctxPojo = new HashMap<String, Object>();
        StringReader stream = new StringReader("1234567890");
        ctxPojo.put("温悦", stream);
        ctxPojo.put("张玮玮", "haha");
        StringWriter writer = new StringWriter();
        TemplateUtil.renderTemplate(temp, ctxPojo, writer);
        assertTrue("hello 1234567890 haha world".equals(writer.toString()));

        // 中文方法调用
        temp = TemplateUtil.parseStringTemplate("hello $!{中文类.获取中文数组()[0]} world");
        ctxPojo = new HashMap<String, Object>();
        ctxPojo.put("中文类", new 中文类());
        writer = new StringWriter();
        TemplateUtil.renderTemplate(temp, ctxPojo, writer);
        assertTrue("hello ^_^ world".equals(writer.toString()));

        // 中文数组调用
        temp = TemplateUtil.parseStringTemplate("hello $!{中文类.中文数组[0]} world");
        ctxPojo = new HashMap<String, Object>();
        ctxPojo.put("中文类", new 中文类());
        writer = new StringWriter();
        TemplateUtil.renderTemplate(temp, ctxPojo, writer);
        assertTrue("hello ^_^ world".equals(writer.toString()));
    }

}
