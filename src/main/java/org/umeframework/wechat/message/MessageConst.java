/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.message;

/**
 * MessageConst
 * 
 * @author Yue Ma
 *
 */
public interface MessageConst {
	// User authentication message
	String UME_WECHAT_MSG_001 = "UME_WECHAT_MSG_001::微信回调Code取得失败。";
	String UME_WECHAT_MSG_002 = "UME_WECHAT_MSG_002::发现openid[{0}]重复的业务用户。";
//	String UME_WECHAT_MSG_002 = "UME_WECHAT_MSG_002::openid[{0}]对应的业务用户创建·更新失败。";
//	String UME_WECHAT_MSG_003 = "UME_WECHAT_MSG_003::openid[{0}]对应的业务用户状态{0}错误。";
	
	String UME_WECHAT_MSG_201 = "UME_WECHAT_MSG_201::数据解析失败，解析目标:{0}。";
	String UME_WECHAT_MSG_202 = "UME_WECHAT_MSG_202::AP0202=数据转化失败，转化对象:{0}。";
	String UME_WECHAT_MSG_203 = "UME_WECHAT_MSG_203::未发现键值为{0}的常量的定义。";
	
	String UME_WECHAT_MSG_301 = "UME_WECHAT_MSG_301::获取微信AccessToken时鉴权失败。";
	String UME_WECHAT_MSG_302 = "UME_WECHAT_MSG_302::获取微信网页授权时鉴权失败。";
}
