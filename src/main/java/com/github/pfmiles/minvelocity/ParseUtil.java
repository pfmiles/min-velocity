package com.github.pfmiles.minvelocity;

/**
 * 默认被加载到context中，辅助模板解析的工具类
 * 
 * @author pf-miles
 * 
 */
public class ParseUtil {

    /**
     * 支持带调用栈(即每层递归调用的context彼此隔离)的parse,
     * 当需要在递归parse过程中保持调用栈时可用于代替velocity中原本的#parse directive
     */
    public static RecParsing recParsing(String tempPath, String basePath) {
        if (tempPath.startsWith("/")) {
            return new RecParsing(tempPath);
        } else {
            return new RecParsing(ImplHelper.resolveAbsName(tempPath, basePath));
        }
    }
}
