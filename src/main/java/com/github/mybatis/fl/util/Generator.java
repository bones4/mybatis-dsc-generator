/**
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.convert
 * @author: flying-cattle  
 * @date: 2019年4月9日 下午8:15:25 
 */
package com.github.mybatis.fl.util;

import com.alibaba.fastjson.JSONObject;
import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.entity.JsonResult;
import com.github.mybatis.fl.entity.PropertyInfo;

import java.io.File;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019
 *
 * <p>说明：  获取文件路径调用创建文件</P>
 * @version: v2.1.0
 * @author: flying-cattle
 *
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * 2019年4月9日      		flying-cattle   v2.1.0           initialize
 */
public class Generator {
	//路径信息
	public static final String ENTITY="entity";
	public static final String DAO="dao";
	public static final String DAO_IMPL="daoImpl";
	public static final String SERVICE="service";
	public static final String SERVICE_IMPL="serviceImpl";
	public static final String CONTROLLER="controller";

	/**
	 * @param url
	 * @param bi
	 * @param root
	 * @param templateName
	 * @param outfileName
	 * @return
	 */
	//①创建自定义类
	public static JsonResult createTemplate(String url,BasisInfo bi,Object root,String templateName,String outfileName) {
		String fileUrl= getGeneratorFileUrl(url, bi.getEntityUrl(), bi.getEntityName(), outfileName);

		return FreemarkerUtil.createFile(bi, templateName, fileUrl,root);
	}

	//①创建实体类
	public static JsonResult createEntity(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getEntityUrl(), bi.getEntityName(), ENTITY);
		return FreemarkerUtil.createFile(bi, "entity.ftl", fileUrl);
	}

	//②创建DAO
	public static JsonResult createDao(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getDaoUrl(), bi.getEntityName(), DAO);
		return FreemarkerUtil.createFile(bi, "dao.ftl", fileUrl);
	}

	//③创建mapper配置文件
	public static JsonResult createDaoImpl(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getMapperUrl(), bi.getEntityName(), DAO_IMPL);
		List<PropertyInfo> list=bi.getCis();
		String agile="";
		for (PropertyInfo propertyInfo : list) {
			agile=agile+propertyInfo.getColumn()+", ";
		}
		agile=agile.substring(0, agile.length()-2);
		bi.setAgile(agile);
		return FreemarkerUtil.createFile(bi, "mapper.ftl", fileUrl);
	}

	//④创建SERVICE
	public static JsonResult createService(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getServiceUrl(), bi.getEntityName(), SERVICE);
		return FreemarkerUtil.createFile(bi, "service.ftl", fileUrl);
	}

	//⑤创建SERVICE_IMPL
	public static JsonResult createServiceImpl(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getServiceImplUrl(), bi.getEntityName(), SERVICE_IMPL);
		return FreemarkerUtil.createFile(bi, "serviceImpl.ftl", fileUrl);
	}

	//⑥创建CONTROLLER
	public static JsonResult createController(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getControllerUrl(), bi.getEntityName(), CONTROLLER);
		return FreemarkerUtil.createFile(bi, "controller.ftl", fileUrl);
	}

	//⑥创建CONTROLLER
	public static JsonResult createController2(String url, BasisInfo bi, JSONObject root) {
		String fileUrl= getGeneratorFileUrl(url, bi.getControllerUrl(), bi.getEntityName(), CONTROLLER);
		return FreemarkerUtil.createFile(bi, "controller2.ftl", fileUrl);
	}


	//生成文件
	public static String getGeneratorFileUrl(String url,String packageUrl,String entityName, String type){
		if (type.equals("entity")) {
			return url+pageToUrl(packageUrl)+entityName+".java";
		}else if(type.equals("dao")) {
			return url+pageToUrl(packageUrl)+entityName+"Mapper.java";
		}else if(type.equals("daoImpl")) {
			return url+pageToUrl(packageUrl)+entityName+"Mapper.xml";
		}else if(type.equals("service")) {
			return url+pageToUrl(packageUrl)+entityName+"Service.java";
		}else if(type.equals("serviceImpl")) {
			return url+pageToUrl(packageUrl)+entityName+"ServiceImpl.java";
		}else if(type.equals("controller")) {
			return url+pageToUrl(packageUrl)+entityName+"Controller.java";
		}
		else if(type.equals("controller2")) {
			return url+pageToUrl(packageUrl)+entityName+"Controller2.java";
		}
		else{
			return url+pageToUrl(packageUrl)+type;
		}
		//return null;
	}

	public static String pageToUrl(String url) {
		return url.replace(".", "/")+"/";
	}
	public static boolean delFile(String filePath ) {
		File file = new File(filePath);
		return  delFile(file);
	}
	public static boolean delFile(File file) {
		if (!file.exists()) {
			return false;
		}

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				delFile(f);
			}
		}
		return file.delete();
	}


	//⑥创建CONTROLLER
	public static JsonResult createInputDto(String url, BasisInfo bi, JSONObject root) {
		String fileUrl= getGeneratorFileUrl(url, bi.getControllerUrl(), bi.getEntityName(),
				ENTITY);
		return FreemarkerUtil.createFile(bi, "entity.ftl", fileUrl);
	}
}
