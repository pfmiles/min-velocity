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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 根据apiMeta，生成业务sdk代码的util类
 * 
 * @author pf-miles 2014-4-10 下午3:53:12
 */
public class ApiCodeGenUtil {

    /**
     * 根据meta信息和集群信息，生成业务sdk java源码
     * 
     * @param infos
     *            ns/api meta
     * @param site
     *            集群/站点
     * @return 业务sdk源码
     */
    public static BizSdkCodeResult generate(List<NsInfo> infos, Site site) {
        BizSdkCodeResult ret = new BizSdkCodeResult();
        ret.setApiFacadeSrc(genApiFacade(infos, site));
        ret.setParamPojosSrc(genParamPojos(infos, site));
        ret.setResultPojosSrc(genResultPojos(infos, site));
        return ret;
    }

    // 生成结果pojo类代码
    private static List<JavaSourceFile> genResultPojos(List<NsInfo> infos, Site site) {
        List<JavaSourceFile> ret = new ArrayList<JavaSourceFile>();
        for (NsInfo ns : infos) {
            for (ApiInfo api : ns.getApiInfos()) {
                Map<String, Object> ctxPojo = new HashMap<String, Object>();
                ctxPojo.put("site", site);
                ctxPojo.put("api", api);
                ctxPojo.put("ns", ns);
                JavaSourceFile rstFile = new JavaSourceFile(StringUtils.capitalize(api.getMethodName()) + "Result.java", site.getBasePkgName()
                        + ".result." + ns.getNsName(), TemplateRenderUtil.render("sdkTemp/code/apiResult.vm", ctxPojo));
                // JavaCodeFormattingUtil.tryFormat(rstFile);
                ret.add(rstFile);
                // 生成深度result类源码：
                for (DeepAttrInfo deepInfo : extractDeepInfos(api.getResultInfo())) {
                    Map<String, Object> deepCtx = new HashMap<String, Object>();
                    deepCtx.put("site", site);
                    deepCtx.put("ns", ns);
                    deepCtx.put("deepInfo", deepInfo);
                    JavaSourceFile deepFile = new JavaSourceFile(StringUtils.capitalize(deepInfo.getAttClsName()) + ".java", site.getBasePkgName()
                            + ".result." + ns.getNsName(), TemplateRenderUtil.render("sdkTemp/code/deepResultBean.vm", deepCtx));
                    // JavaCodeFormattingUtil.tryFormat(deepFile);
                    ret.add(deepFile);
                }
            }
        }
        return ret;
    }

    private static List<DeepAttrInfo> extractDeepInfos(Map<String, Object> resultInfo) {
        List<DeepAttrInfo> ret = new ArrayList<DeepAttrInfo>();
        for (Object v : resultInfo.values()) {
            if (v instanceof DeepAttrInfo) {
                ret.add((DeepAttrInfo) v);
                ret.addAll(extractDeepInfos((DeepAttrInfo) v));
            }
        }
        return ret;
    }

    // 生成参数pojo类代码
    private static List<JavaSourceFile> genParamPojos(List<NsInfo> infos, Site site) {
        List<JavaSourceFile> ret = new ArrayList<JavaSourceFile>();
        for (NsInfo ns : infos) {
            for (ApiInfo api : ns.getApiInfos()) {
                Map<String, Object> ctxPojo = new HashMap<String, Object>();
                ctxPojo.put("site", site);
                ctxPojo.put("api", api);
                ctxPojo.put("ns", ns);
                JavaSourceFile paramFile = new JavaSourceFile(StringUtils.capitalize(api.getMethodName()) + "Param.java", site.getBasePkgName()
                        + ".param." + ns.getNsName(), TemplateRenderUtil.render("sdkTemp/code/apiParam.vm", ctxPojo));
                // JavaCodeFormattingUtil.tryFormat(paramFile);
                ret.add(paramFile);
            }
        }
        return ret;
    }

    // 生成api主类代码
    private static JavaSourceFile genApiFacade(List<NsInfo> infos, Site site) {
        Map<String, Object> ctxPojo = new HashMap<String, Object>();
        ctxPojo.put("infos", infos);
        ctxPojo.put("site", site);
        JavaSourceFile ret = new JavaSourceFile(site.getMainClsName() + ".java", site.getBasePkgName(), TemplateRenderUtil.render(
                "sdkTemp/code/ApiFacade.vm", ctxPojo));
        // JavaCodeFormattingUtil.tryFormat(ret);
        return ret;
    }

    public static void main(String... args) throws IOException {
        // 测试生成主类:
        List<NsInfo> infos = new ArrayList<NsInfo>();
        infos.add(fakeNsInfo());
        System.out.println(genApiFacade(infos, Site.CBU).getCharContent(true));
        // 测试生成参数类：
        List<NsInfo> infos1 = new ArrayList<NsInfo>();
        infos1.add(fakeNsInfo());
        System.out.println(genParamPojos(infos1, Site.CBU).get(0).getCharContent(true));
        // 测试生成结果类：
        List<NsInfo> infos2 = new ArrayList<NsInfo>();
        infos2.add(fakeNsInfo());
        for (JavaSourceFile s : genResultPojos(infos2, Site.CBU)) {
            System.out.println(s.getName() + ": ");
            System.out.println(s.getCharContent(true));
        }
    }

    private static NsInfo fakeNsInfo() {
        NsInfo ret = new NsInfo();
        ret.setNsName("cn.alibaba.member");
        ret.setNsInterfaceName("CnAlibabaMember");
        List<ApiInfo> apiInfos = new ArrayList<ApiInfo>();
        apiInfos.add(fakeApiInfo());
        ret.setApiInfos(apiInfos);
        return ret;
    }

    private static ApiInfo fakeApiInfo() {
        ApiInfo ret = new ApiInfo();
        ret.setApiName("member.get");
        ret.setApiVer(1);
        ret.setDoc("根据memberId获取会员完整信息，disabled的会员信息也能获取");
        ret.setInnerApi(true);
        ret.setMethodName("memberGet1");
        ret.setNeedAuthorization(true);
        ret.setNeedHttps(false);
        ret.setNeedSignature(false);
        ret.setNeedTimeStamp(true);
        Map<String, Class<?>> paramInfo = new HashMap<String, Class<?>>();
        paramInfo.put("memberId", String.class);
        paramInfo.put("alive", boolean.class);
        paramInfo.put("age", Integer.class);
        ret.setParamInfo(paramInfo);
        Map<String, Object> resultInfo = new HashMap<String, Object>();
        resultInfo.put("name", String.class);
        resultInfo.put("age", int.class);
        resultInfo.put("male", Boolean.class);
        DeepAttrInfo detailMeta = new DeepAttrInfo();
        detailMeta.setAttClsName("MemberDetail");
        detailMeta.put("phone", String.class);
        detailMeta.put("interest", String.class);
        detailMeta.put("money", double.class);
        DeepAttrInfo moreDetailMeta = new DeepAttrInfo();
        moreDetailMeta.setAttClsName("MoreDetail");
        moreDetailMeta.put("spouse", String.class);
        moreDetailMeta.put("size", int.class);
        moreDetailMeta.put("married", Boolean.class);
        detailMeta.put("moreDetail", moreDetailMeta);
        resultInfo.put("detail", detailMeta);
        ret.setResultInfo(resultInfo);
        ret.setResultLocatingExpr("/test/test1[2]/test2");
        return ret;
    }
}
