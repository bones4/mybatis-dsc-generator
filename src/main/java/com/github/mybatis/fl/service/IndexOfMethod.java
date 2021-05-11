package com.github.mybatis.fl.service;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * @Description:
 * @Author: zhangwei
 * @CreateDate: 2019/12/24 10:01
 */
public class IndexOfMethod implements TemplateMethodModel {

    @Override
    public TemplateModel exec(List args) throws TemplateModelException {
        if (args.size() != 2) {
            throw new TemplateModelException("Wrong arguments");
        }
        return new SimpleNumber(((String) args.get(1)).indexOf((String) args.get(0)));
    }
}
