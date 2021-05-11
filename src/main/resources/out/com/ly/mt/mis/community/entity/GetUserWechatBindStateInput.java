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
public class GetUserWechatBindStateInput implements Serializable {

	@ApiModelProperty("绑定状态")
	private String status;
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
}
