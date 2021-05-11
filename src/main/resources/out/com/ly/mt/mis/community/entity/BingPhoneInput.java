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
public class BingPhoneInput implements Serializable {

	@ApiModelProperty("用户Id")
	private String userId;
	@ApiModelProperty("用户手机号")
	private String phone;
    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
}
