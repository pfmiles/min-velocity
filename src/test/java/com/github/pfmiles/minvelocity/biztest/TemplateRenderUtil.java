/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.github.pfmiles.minvelocity.biztest;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import com.github.pfmiles.org.apache.velocity.VelocityContext;
import com.github.pfmiles.org.apache.velocity.app.VelocityEngine;
import com.github.pfmiles.org.apache.velocity.context.Context;
import com.github.pfmiles.org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * 渲染模板util, 用于根据业务数据和模板文件，生成java源码、pdf文档等
 * 
 * @author pf-miles 2014-4-10 上午11:42:34
 */
public class TemplateRenderUtil {

    private static final Properties props = new Properties();
    private static final VelocityEngine tempEngine = new VelocityEngine();
    static {
        props.put(VelocityEngine.ENCODING_DEFAULT, "UTF-8");
        props.put(VelocityEngine.INPUT_ENCODING, "UTF-8");
        props.put(VelocityEngine.RESOURCE_LOADER, "classpath");
        props.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        props.put(VelocityEngine.SET_NULL_ALLOWED, "true");
        try {
            tempEngine.init(props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 传入模板路径(classpath中的路径)，以及任意pojo或map形式的context，返回merge好的String结果
     * 
     * @param tempPath
     *            模板路径, 以classpath根为起始
     * @param ctxPojo
     *            任意自定义pojo context，需提供符合javaBean规范的getter方法, 或map
     * @return merge好的String结果
     */
    public static <T> String render(String tempPath, T ctxPojo) {
        Context ctx = new VelocityContext();
        putAllPojoVals(ctxPojo, ctx);
        StringWriter writer = new StringWriter();
        try {
            tempEngine.mergeTemplate(tempPath, "UTF-8", ctx, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }

    private static void putAllPojoVals(Object ctxPojo, Context ctx) {
        ctx.put("StringUtils", StringUtils.class);
        ctx.put("ClassUtils", ClassUtils.class);
        ctx.put("BizUtil", BizUtil.class);
        if (ctxPojo == null)
            return;
        if (ctxPojo instanceof Map) {
            for (Map.Entry<?, ?> e : ((Map<?, ?>) ctxPojo).entrySet()) {
                ctx.put(e.getKey().toString(), e.getValue());
            }
        } else {
            BeanInfo bi;
            try {
                bi = Introspector.getBeanInfo(ctxPojo.getClass());
                for (PropertyDescriptor pd : bi.getPropertyDescriptors()) {
                    if ("class".equals(pd.getName()))
                        continue;
                    Method rm = pd.getReadMethod();
                    if (rm != null)
                        ctx.put(pd.getName(), rm.invoke(ctxPojo));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
