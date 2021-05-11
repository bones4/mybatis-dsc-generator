package com.github.mybatis.fl.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program:
 * @description:
 * @author: zhangwei
 * @create: 2019/11/5 19:18
 */
public class AppUtils {
    private final static Logger logger = LoggerFactory.getLogger(AppUtils.class);




    /**
     * 去掉字符串里第一个"?"号以后的部分
     * @param str
     * @param removeflag
     * @return
     */
    public static String RemoveAfter(String str,String removeflag) {
        int index =str.indexOf(removeflag);
        if(index==-1){
            return  str;
        }
        else{
         return  str.substring(0,index);
        }

    }

    /**
     * 检查对象的状态
     * 当对象状态保存为1/0，需要检查是true/false，
     * 意外情况返回false并记录异常
     * @param status
     * @return
     */
    public static boolean checkStatus(String status) {
        int value = 0;
        try {
            value = Integer.parseInt(status);
        } catch (Exception ex) {
            value = 0;
            logger.warn("检查状态异常|status={}", status);
        }
        if (value == 1) {
            return true;
        } else if (value == 0) {
            return false;
        } else {
            logger.warn("检查状态异常|status={}", status);
            return false;
        }
    }

    /**
     * java对象类型转换
     *
     * @param sourceJavaObject
     * @param targetClass
     * @param <T>
     * @return 用法：
     * //将user从User类型转为UserVo
     * UserVo userVo=Test.toJavaObject(user,UserVo.class);
     */
    public static <T> T toJavaObject(Object sourceJavaObject, Class<T> targetClass) {
        try {
            T targetJavaObject = (T) JSON.toJavaObject((JSON) JSON.toJSON(sourceJavaObject), targetClass);
            return targetJavaObject;
        } catch (Exception ex) {
            logger.error("java对象类型转换失败|sourceJavaObject={},targetClass={}", sourceJavaObject, targetClass, ex);
        }
        return null;
    }

    public static void main(String[] arg){
       System.out.println(AppUtils.RemoveAfter("http://moti-dev.oss-cn-beijing.aliyuncs.com/image/community/dynamic/651458485757669376.jpg?Expires=1575908409&OSSAccessKeyId=LTAItbmtUS0mjRGt&Signature=0NTcrnuxFVY8Y2y8oPm%2F272L1eY%3D","?"));
    }
}
