/**
 * @filename:UserController 2019年4月9日
 * @project wallet-manage  V1.0
 * Copyright(c) 2018 BianPeng Co. Ltd. 
 * All right reserved. 
 */
package com.github.mybatis.fl.test;

import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.util.EntityInfoUtil;
import com.github.mybatis.fl.util.Generator;
import com.github.mybatis.fl.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
	// 基础信息：项目名、作者、版本
	public static final String PROJECT = "community";
	public static final String AUTHOR = "zhangwei";
	public static final String VERSION = "V1.0";
	// 数据库连接信息：连接URL、用户名、秘密、数据库名
	public static final String URL = "jdbc:mysql://leiyankeji.mysql.rds.aliyuncs.com:3306/mt-shop-dev?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
	public static final String NAME = "mt_dev";
	public static final String PASS = "mt_dev_2019";
	public static final String DATABASE = "mt-shop-dev";
	// 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
	public static final String TABLE = "user_device";
	public static final String CLASSNAME = "UserDevice";
	public static final String CLASSCOMMENT = "用户设备";
	public static final String TIME =  new SimpleDateFormat("yyyy年MM月dd日").format(new Date());;
	public static final String AGILE = System.currentTimeMillis() + "";
	// 路径信息，分开路径方便聚合工程项目，微服务项目
	public static final String ENTITY_URL = "com.ly.mt.community.entity";
	public static final String DAO_URL = "com.ly.mt.community.mapper";
	public static final String XML_URL = "com.ly.mt.community.xml";
	public static final String SERVICE_URL = "com.ly.mt.community.service";
	public static final String SERVICE_IMPL_URL = "com.ly.mt.community.service.impl";
	public static final String CONTROLLER_URL = "com.ly.mt.community.web";

	public  static  final String rootPath="D:\\workspace\\git\\gitlab.temp\\mybatis-dsc-generator-master\\src\\main\\out\\";

	public static void main(String[] args) {
		BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
				DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
		bi.setTable(TABLE);
		bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		bi.setEntityComment(CLASSCOMMENT);
		try {
			bi = EntityInfoUtil.getInfo(bi);
			String fileUrl = rootPath;// 生成文件存放位置
			Generator.delFile(fileUrl);
			String aa1 = Generator.createEntity(fileUrl, bi).toString();

			String aa2 = Generator.createDao(fileUrl, bi).toString();
			String aa3 = Generator.createDaoImpl(fileUrl, bi).toString();
			String aa4 = Generator.createService(fileUrl, bi).toString();
			String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
			String aa6 = Generator.createController(fileUrl, bi).toString();

			// 是否创建swagger配置文件
			// String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();

			System.out.println(aa1);
			System.out.println(aa2);
			System.out.println(aa3);
			System.out.println(aa4);
			System.out.println(aa5);
			System.out.println(aa6);

			// System.out.println(aa7);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
}
