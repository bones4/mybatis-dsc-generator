package com.github.mybatis.fl.service;

import com.alibaba.fastjson.JSON;

/**
 * @Description:
 * @Author: zhangwei
 * @CreateDate: 2019/12/24 18:59
 */
public class MyJson {
    public static String toJson(Object src) {
        String json = JSON.toJSONString(src);
        return json;
    }
}