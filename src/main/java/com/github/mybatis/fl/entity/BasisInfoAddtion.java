package com.github.mybatis.fl.entity;

/**包含基本信息和 一个ProperyuInfo对象，
 * 用于输出input和output
 * @Description:
 * @Author: zhangwei
 * @CreateDate: 2020/1/2 10:45
 */

import com.github.mybatis.fl.service.UtilMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasisInfoAddtion implements Serializable {
     private BasisInfo base;
     private PropertyInfo method;

    /**
     * 通过基础信息和方法对象创建一个方法模板
     * 还需要对input和output做转换处理
     * @param bi
     * @param obj
     * @return
     */
    public static BasisInfoAddtion create(BasisInfo bi, PropertyInfo obj) {
        obj.getAtter().put("inputName", UtilMethod.toUpperCaseFirstOne(
                obj.getAtter().get("name"))+"Input");
        obj.getAtter().put("outputName", UtilMethod.toUpperCaseFirstOne(
                obj.getAtter().get("name"))+"Output");


        BasisInfoAddtion basisInfoAddtion=new BasisInfoAddtion();
        basisInfoAddtion.setBase(bi);
        basisInfoAddtion.setMethod(obj);
        return  basisInfoAddtion;
    }
}
