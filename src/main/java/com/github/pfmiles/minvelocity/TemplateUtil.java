package com.github.pfmiles.minvelocity;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.github.pfmiles.org.apache.commons.collections.ExtendedProperties;
import com.github.pfmiles.org.apache.velocity.VelocityContext;
import com.github.pfmiles.org.apache.velocity.app.VelocityEngine;
import com.github.pfmiles.org.apache.velocity.context.Context;
import com.github.pfmiles.org.apache.velocity.runtime.RuntimeConstants;

/**
 * @author pf-miles
 * 
 */
public class TemplateUtil {

    private static ExtendedProperties props = new ExtendedProperties();
    private static final VelocityEngine tempEngine = new VelocityEngine();
    static {
        try {
            InputStream propStream = ImplHelper.getCurrentClsLoader().getResourceAsStream("min-velocity.properties");
            if (propStream != null) {
                tempEngine.getLog().debug("'min-velocity.properties' at classpath root found, loading...");
                props.load(propStream, "UTF-8");
            }
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
        ctx.put("ParseUtil", ParseUtil.class);
        putAllDefaultStaticUtils(ctx);
        putAllPojoVals(ctxPojo, ctx);
        StringWriter writer = new StringWriter();
        try {
            tempEngine.mergeTemplate(tempPath, "UTF-8", ctx, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }

    @SuppressWarnings("unchecked")
    private static void putAllDefaultStaticUtils(Context ctx) {
        List<String> ms = (List<String>) tempEngine.getProperty(RuntimeConstants.DEFAULT_STATIC_UTIL_MAPPINGS);
        if (ms != null)
            for (String m : ms) {
                String[] kv = m.split(":");
                try {
                    ctx.put(kv[0].trim(), ImplHelper.getCurrentClsLoader().loadClass(kv[1].trim()));
                } catch (ClassNotFoundException e) {
                    tempEngine.getLog().error("Could not load static util class: " + kv[0], e);
                }
            }
    }

    private static void putAllPojoVals(Object ctxPojo, Context ctx) {
        ctx.put("ParseUtil", ParseUtil.class);
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
