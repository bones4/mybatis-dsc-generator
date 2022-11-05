package com.ly.mt.mis.community.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * @program:community
 * @description: User
 * @author: zhangwei
 * @create: 2021年05月11日
 */
@ApiModel
public class GetWechatAppIdByNiceNameInput implements Serializable {

	@ApiModelProperty("微信应用appId")
	private String appId;
    public String getAppId() {return appId;}
    public void setAppId(String appId) {this.appId = appId;}
}