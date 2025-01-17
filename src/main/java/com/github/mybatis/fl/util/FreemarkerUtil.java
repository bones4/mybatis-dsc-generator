/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.convert
 * @author: flying-cattle  
 * @date: 2019年4月9日 下午8:15:25 
 */
package com.github.mybatis.fl.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.entity.JsonResult;
import com.github.mybatis.fl.service.IndexOfMethod;
import com.github.mybatis.fl.service.UtilMethod;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明：  创建文件</P>
 * @version: v2.1.0
 * @author: flying-cattle
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * 2019年4月9日      		flying-cattle   v2.1.0           initialize
 */
public class FreemarkerUtil {
	public static JsonResult createFile(BasisInfo dataModel, String templateName, String filePath) {
		return  createFile(dataModel,templateName,filePath,null);
	}
	public static JsonResult createFile(BasisInfo dataModel, String templateName, String filePath,Object data) {
		JsonResult result=new JsonResult();
		FileWriter out = null;
		String fileName=dataModel.getEntityName()+messageStr(templateName);
		try {
			// 通过FreeMarker的Confuguration读取相应的模板文件
	        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
	        // 设置模板路径
	        configuration.setClassForTemplateLoading(FreemarkerUtil.class, "/freemarker/ftl");
	        // 设置默认字体
	        configuration.setDefaultEncoding("utf-8");

	        // 获取模板
			Template template = configuration.getTemplate(templateName);
			File file = new File(filePath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if(!file.exists()) {
                file.createNewFile();
            }else {
            	result.setCode(-1);
            	result.setMessage("已经存在"+fileName);
            	return result;
            }
			
			//设置输出流
            out = new FileWriter(file);
            //模板输出静态文件
			JSONObject root= JSONObject.parseObject(JSON.toJSONString(dataModel));
			if(data!=null){
				root=JSONObject.parseObject(JSON.toJSONString(data));
			}
			//todo 增加自定义方法
			root.put("indexOf", new IndexOfMethod());
			root.put("util", new UtilMethod());
			root.put("Json", "com.github.mybatis.fl.service.MyJson");
			//核心的模板渲染方法
            template.process(root, out);
            result.setCode(1);
        	result.setMessage("创建"+fileName+"成功");
        	return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		result.setCode(-1);
    	result.setMessage("创建"+fileName+"失败");
    	return result;
	}
	
	public static String messageStr(String name) {
		if (name.equals("entity.ftl")) {
			name=".java";
		} else if(name.equals("dao.ftl")){
			name="Dao.java";
		} else if(name.equals("mapper.ftl")){
			name="Mapper.xml";
		} else if(name.equals("service.ftl")){
			name="Service.java";
		} else if(name.equals("serviceImpl.ftl")){
			name="ServiceImpl.java";
		} else if(name.equals("controller.ftl")){
			name="Controller.java";
		} 
		return name;
	}
}
