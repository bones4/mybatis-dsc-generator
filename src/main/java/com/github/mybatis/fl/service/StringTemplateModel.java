package com.github.mybatis.fl.service;

import freemarker.template.TemplateModel;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhangwei
 * @CreateDate: 2019/12/24 10:45
 */
public class StringTemplateModel implements TemplateModel,Serializable {
    private final String value;

    public StringTemplateModel(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value.toString();
    }
}
