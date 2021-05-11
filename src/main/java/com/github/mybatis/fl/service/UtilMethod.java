package com.github.mybatis.fl.service;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * @Description:
 * @Author: zhangwei
 * @CreateDate: 2019/12/24 10:37
 */
public class UtilMethod   implements TemplateMethodModel {
    @Override
    public Object  exec(List args) throws TemplateModelException {
        if (args.size() != 2) {
            throw new TemplateModelException("Wrong arguments");
        }
        //JSONObject parm = JSONObject.parseObject((String)args.get(0));
        String result=handle((String)args.get(0),args.get(1));

        return new SimpleScalar(result);
    }

    private String handle(String name,Object value) {
        String result=null;
        if(name.equals("fristLower")){
            //${util("fristCase:"+project+"")}
            result=toLowerCaseFirstOne(value.toString());
        }
        else if (name.equals("fristUpper")){
            //${util("fristCase:"+project+"")}
            result=toUpperCaseFirstOne(value.toString());
        }
        else if (name.equals("output")){
            //${util("fristCase:"+project+"")}
            result=output(value);
        }
        return  result;
    }

    private String output(Object value) {
        String type= value.getClass().getTypeName();
        return "";
    }


    /**
     * 首字母转大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
