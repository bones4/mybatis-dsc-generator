/**
 * @program:community
 * @description: User控制层
 * @author: zhangwei
 * @create: 2021年05月11日
 */
package com.ly.mt.mis.community.web;
#方法

@ApiOperation(value = "根据项目别名获取微信appid", notes = "")
@PostMapping("/getWechatAppIdByNiceName")
@CustomLog
public ResponseJson<GetWechatAppIdByNiceNameOutput> getWechatAppIdByNiceName( @RequestBody GetWechatAppIdByNiceNameInput input ){
    //校验参数

      if (StringUtil.isEmpty(input.getAppId())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "appId为空!");
     }
 }



@ApiOperation(value = "用户绑定手机号", notes = "")
@PostMapping("/bingPhone")
@CustomLog
public ResponseJson<BingPhoneOutput> bingPhone( @RequestBody BingPhoneInput input ){
    //校验参数

      if (StringUtil.isEmpty(input.getUserId())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "userId为空!");
     }

      if (StringUtil.isEmpty(input.getPhone())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "phone为空!");
     }
 }



@ApiOperation(value = "用户设置密码", notes = "")
@PostMapping("/setPassword")
@CustomLog
public ResponseJson<SetPasswordOutput> setPassword( @RequestBody SetPasswordInput input ){
    //校验参数

      if (StringUtil.isEmpty(input.getUserId())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "userId为空!");
     }

      if (StringUtil.isEmpty(input.getPassword())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "password为空!");
     }
 }



@ApiOperation(value = "查询已登录用户微信绑定状态", notes = "返回是否")
@PostMapping("/getUserWechatBindState")
@CustomLog
public ResponseJson<GetUserWechatBindStateOutput> getUserWechatBindState( @RequestBody GetUserWechatBindStateInput input ){
    //校验参数

      if (StringUtil.isEmpty(input.getStatus())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "status为空!");
     }
 }



@ApiOperation(value = "微信解绑", notes = "")
@PostMapping("/unBindWechat")
@CustomLog
public ResponseJson<UnBindWechatOutput> unBindWechat( @RequestBody UnBindWechatInput input ){
    //校验参数

      if (StringUtil.isEmpty(input.getUserId())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "userId为空!");
     }
 }


