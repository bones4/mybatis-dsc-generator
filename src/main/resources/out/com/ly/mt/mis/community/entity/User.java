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
@ApiModel("User")
public class User implements Serializable {

	@ApiModelProperty("Id")
	private String id;
	@ApiModelProperty("到家B端APP用户唯一码")
	private String clientId;
	@ApiModelProperty("用户姓名")
	private String userName;
	@ApiModelProperty("电话")
	private String mobile;
	@ApiModelProperty("邮箱")
	private String email;
	@ApiModelProperty("微信的OpenId")
	private String wxOpenId;
	@ApiModelProperty("QQ的OpenId")
	private String qqOpenId;
	@ApiModelProperty("登录账号")
	private String loginName;
	@ApiModelProperty("密码")
	private String password;
	@ApiModelProperty("用户身份证")
	private String idCard;
	@ApiModelProperty("性别")
	private String sex;
	@ApiModelProperty("生日")
	private String birthday;
	@ApiModelProperty("省（直辖市）代码")
	private String provinceCode;
	@ApiModelProperty("省辖市代码")
	private String cityCode;
	@ApiModelProperty("县区代码")
	private String districtCode;
	@ApiModelProperty("用户类型（1：普通用户，2：企业用户，3：卖家用户，4：平台用户）7:蓝牙APP")
	private String userType;
	@ApiModelProperty("昵称")
	private String nickName;
	@ApiModelProperty("当前用户状态 10：正常状态，20：停用状态)")
	private String userStatus;
	@ApiModelProperty("店铺id")
	private String shopId;
	@ApiModelProperty("审核人（平台用户Id）")
	private String auditor;
	@ApiModelProperty("审核备注")
	private String auditRemark;
	@ApiModelProperty("头像url")
	private String avatarPicSrc;
	@ApiModelProperty("通知配置(10支付退款异常通知)")
	private String noticeConfig;
	@ApiModelProperty("是否首次登陆 0:是 1:否")
	private String firstLogin;
	@ApiModelProperty("最后登录时间")
	private String lastLoginTime;
	@ApiModelProperty("最后登录ip")
	private String lastLoginIp;
	@ApiModelProperty("注册来源：1：到家C端H5商城,2：到家C端微信小程序,3：到家C端App，4：活动页注册,5:格子柜C,6:格子柜B,7:蓝牙APP,8:ofo,9:对接到扑克牌的活动页")
	private String quickType;
	@ApiModelProperty("媒体渠道")
	private String channel;
	@ApiModelProperty(" 媒体素材号")
	private String material;
	@ApiModelProperty(" 数据来源")
	private String dataSource;
	@ApiModelProperty("项目类型:101-格子柜B,102-格子柜C,201-到家B,202-到家C301-蓝牙APP,401-广告活动,1000-运营系统")
	private String projectType;
	@ApiModelProperty("创建时间")
	private String createTime;
	@ApiModelProperty("创建人")
	private String createUser;
	@ApiModelProperty("修改时间")
	private String updateTime;
	@ApiModelProperty("修改人")
	private String updateUser;
	@ApiModelProperty("有效状态")
	private String validStatus;
	@ApiModelProperty("有效状态操作时间")
	private String validTime;
	@ApiModelProperty("有效状态操作人")
	private String validUser;
	@ApiModelProperty("帐号类型")
	private String accountType;
	@ApiModelProperty("首次登陆时间")
	private String firstLoginTime;
	@ApiModelProperty("默认头像")
	private String avatarPicSrcDefault;
	@ApiModelProperty("个性签名")
	private String userSign;
}
