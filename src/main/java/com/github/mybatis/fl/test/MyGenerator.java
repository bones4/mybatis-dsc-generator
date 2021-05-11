/**
 * @filename:UserController 2019年4月9日
 * @project wallet-manage  V1.0
 * Copyright(c) 2018 BianPeng Co. Ltd. 
 * All right reserved. 
 */
package com.github.mybatis.fl.test;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.entity.BasisInfoAddtion;
import com.github.mybatis.fl.entity.ParamObj;
import com.github.mybatis.fl.entity.PropertyInfo;
import com.github.mybatis.fl.service.IndexOfMethod;
import com.github.mybatis.fl.service.UtilMethod;
import com.github.mybatis.fl.util.AppUtils;
import com.github.mybatis.fl.util.EntityInfoUtil;
import com.github.mybatis.fl.util.Generator;
import com.github.mybatis.fl.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Copyright: Copyright (c) 2019
 *
 * <p>
 * 说明： 自动生成工具
 * </P>
 * <p>
 * 源码地址：https://gitee.com/flying-cattle/mybatis-dsc-generator
 * </P>
 */
public class MyGenerator {
	//v1.1服务端补充参数


	// 基础信息：项目名、作者、版本
	public static final String PROJECT = "community";
	public static final String PROJECTTAG = "社区";
	public static final String AUTHOR = "zhangwei";
	public static final String VERSION = "V1.0";
	// 数据库连接信息：连接URL、用户名、秘密、数据库名
	public static final String URL = "jdbc:mysql://127.0.0.1:3308/mt-dev?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
	public static final String NAME = "root";
	public static final String PASS = "admin@123#";
	public static final String DATABASE = "mt-dev";
	// 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
	/*
	* UserFeedBackPlus,user_feedback_plus
	*
	* */
	public static final String TABLE = "user";
	public static final String CLASSNAME = "User";
	public static final String CLASSCOMMENT = "User";
	public static final String TIME =  new SimpleDateFormat("yyyy年MM月dd日").format(new Date());;
	public static final String AGILE = System.currentTimeMillis() + "";
	// 路径信息，分开路径方便聚合工程项目，微服务项目
	public static final String ENTITY_URL = "com.ly.mt.mis.community.entity";
	public static final String DAO_URL = "com.ly.mt.mis.community.mapper";
	public static final String XML_URL = "com.ly.mt.mis.community.xml";
	public static final String SERVICE_URL = "com.ly.mt.mis.community.service";
	public static final String SERVICE_IMPL_URL = "com.ly.mt.mis.community.service.impl";
	public static final String CONTROLLER_URL = "com.ly.mt.mis.community.web";

//    public static final String ENTITY_URL = "com.ly.mt.user.base.entity";
//	public static final String DAO_URL = "com.ly.mt.user.base.mapper";
//	public static final String XML_URL = "com.ly.mt.user.base.xml";
//	public static final String SERVICE_URL = "com.ly.mt.user.base.service";
//	public static final String SERVICE_IMPL_URL = "com.ly.mt.user.base.service.impl";
//	public static final String CONTROLLER_URL = "com.ly.mt.user.base.web";


    public  static  final String rootPath="D:\\workspace\\git\\bones4\\mybatis-dsc-generator\\src\\main\\resources\\out\\";



	public static void main(String[] args) {
		BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
				DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
		bi.setProjectTag(PROJECTTAG);
		//载入服务接口定义信息
		loadService(bi,"template/service/server.json");
		//bi.setItems(getItems());

		bi.setTable(TABLE);
		//bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
		bi.setEntityName(CLASSNAME);
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		bi.setEntityComment(CLASSCOMMENT);


		try {
			bi = EntityInfoUtil.getInfo(bi);
			JSONObject root= JSONObject.parseObject(JSON.toJSONString(bi));
			root.put("indexOf", new IndexOfMethod());
			String fileUrl = rootPath;// 生成文件存放位置
			Generator.delFile(fileUrl);
			String aa1 = Generator.createEntity(fileUrl, bi).toString();
			String aa2 = Generator.createDao(fileUrl, bi).toString();
			String aa3 = Generator.createDaoImpl(fileUrl, bi).toString();
			String aa4 = Generator.createService(fileUrl, bi).toString();
			String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
			//String aa6 = Generator.createController(fileUrl, bi).toString();

			String aa7 = Generator.createController2(fileUrl, bi,root).toString();
			//另外基于方法单独生成模板
			for(PropertyInfo obj : bi.getMotheds()) {
				BasisInfoAddtion basisInfoAddtion=BasisInfoAddtion.create(bi,obj);
				String aa8 = Generator.createTemplate(fileUrl, bi,basisInfoAddtion ,"entityInput.ftl",
						UtilMethod.toUpperCaseFirstOne(obj.getAtter().get("inputName"))	+".java"
				).toString();
				String aa9 = Generator.createTemplate(fileUrl, bi, basisInfoAddtion,"entityOutput.ftl",
						UtilMethod.toUpperCaseFirstOne(obj.getAtter().get("outputName"))+".java"
						).toString();
			}
			// 是否创建swagger配置文件
			// String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();
//			System.out.println(aa1);
//			System.out.println(aa2);
//			System.out.println(aa3);
//			System.out.println(aa4);
//			System.out.println(aa5);
//			System.out.println(aa6);

			// System.out.println(aa7);

			//测试读取db的表信息，和表的字段信息
			runLoadDBInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  测试读取db的表信息，和表的字段信息
	 */
	private static void runLoadDBInfo() {

	}

	private static void loadService(BasisInfo bi, String filepath) {
		FileReader fileReader = new FileReader(filepath);
		String result = fileReader.readString();
		JSONObject service=JSONObject.parseObject(result);
		//bi.service
		//bi.service
		bi.setService((Map)service);//
		JSONArray motheds= service.getJSONArray("motheds");
		List<PropertyInfo> items =new ArrayList<>();
		for(Object jsonObject: motheds){
			JSONObject mothed =(JSONObject) jsonObject;
			PropertyInfo propertyInfo=new PropertyInfo();
			propertyInfo.setAtter((Map)mothed);

			List<ParamObj> inputs=new ArrayList<>();
		    JSONArray input=mothed.getJSONArray("input");
			if(input!=null) {
				for (Object item : input) {
					inputs.add(AppUtils.toJavaObject(item, ParamObj.class));
				}
				propertyInfo.setInput(inputs);
			}

			List<ParamObj> outputs=new ArrayList<>();
			JSONArray output=mothed.getJSONArray("output");
			if(output!=null) {
				for (Object item : output) {
					outputs.add(AppUtils.toJavaObject(item, ParamObj.class));
				}
				propertyInfo.setInput(outputs);
			}

			items.add(propertyInfo);


		}
		bi.setMotheds(items);

	}



	public static  String getDate(){
		new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		String dateStr=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date time=null;
		try {
			dateStr=sdf.format(new Date());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return  dateStr;
	}

	public static List<PropertyInfo> getItems() {
		//灵活点，多种方式，改旧数据，造新数据，
		List<PropertyInfo> items =new ArrayList<>();

		//PropertyInfo propertyInfo=new PropertyInfo();
		//propertyInfo.setAtter();
		//items.add()
		return items;
	}


}
