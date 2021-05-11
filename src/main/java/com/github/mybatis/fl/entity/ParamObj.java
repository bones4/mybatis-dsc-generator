package com.github.mybatis.fl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhangwei
 * @CreateDate: 2019/12/31 18:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamObj implements Serializable {
    private String tag;

    private String name;

    private String type;

    private String required="";
}
