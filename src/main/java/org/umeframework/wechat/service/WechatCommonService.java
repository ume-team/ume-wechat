/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service;

import org.umeframework.wechat.service.dto.WechatBaseAccTokenDto;
import org.umeframework.wechat.service.dto.WechatJsapiSignatureDto;
import org.umeframework.wechat.service.dto.WechatTemplateDto;
import org.umeframework.wechat.service.dto.WechatUserDto;
import org.umeframework.wechat.service.dto.WechatWebAccTokenDto;

/**
 * 微信共通管理组件 <br>
 * 提供微信共通的统一管理服务  <br>
 *
 * @author MA YUE
 */
public interface WechatCommonService {

    /**
     * 查询微信访问凭证 <br>
     * 根据APP识别代码查询对应的微信访问凭证 <br>
     *
     * @return 微信访问凭证（access_token） (String)
     */
    String getAccessToken ();
    
    /**
     * 刷新微信访问凭证 <br>
     * 
     * @param appid
     * @param secretKey
     * @return
     */
    WechatBaseAccTokenDto refreshAccessToken(String appid, String secretKey);

    /**
     * 查询微信用户网页授权信息 <br>
     * 根据accessCode换取微信网页授权信息 <br>
     *
     * @param accessCode - 微信回调accessCode
     * @return 微信网页授权信息 (WechatWebAccTokenDTO)
     */
    WechatWebAccTokenDto getWechatWebAccTokenDTO ( String accessCode );

    /**
     * 查询微信用户基础信息 <br>
     * 根据openid和accessToken查询微信用户基础信息 <br>
     *
     * @param openid - 微信用户openid
     * @param accessToken - 微信网页授权Token
     * @return 微信用户基础信息对象 (WechatUserDTO)
     */
    WechatUserDto getWechatUserData ( String openid , String accessToken );

    /**
     * 下载微信临时存贮资源至本地存贮 <br>
     * 根据传入的资源ID列表，分别下载资源至本地存贮 <br>
     *
     * @param category - 资源类别
     * @param ids - 资源ID列表
     * @return 资源取得后的本地存贮位置列表 (String[])
     */
    String[] downloadWechatTmpRes ( String category , String[] ids );

    /**
     * 获取微信JSAPI接口权限验证信息 <br>
     * 根据accessCode和网页Url以网页授权方式获取微信JS接口的临时票据后，使用JS-SDK使用权限签名算法生成JSAPI接口权限验证信息 <br>
     *
     * @param url - 网页Url
     * @return 微信JSAPI接口权限验证信息 (WechatJsapiSignatureDTO)
     */
    WechatJsapiSignatureDto getWechatJsapiSignature ( String url );

    
    /**
     * 获取微信JSAPI接口授权凭证 <br>
     * 
     * @param accessToken
     * @return
     */
    String getWechatJsapiTicket(String accessToken);
    
    /**
     * 发送微信通知 <br>
     * 发送微信通知 <br>
     *
     * @param wechatTemplateDTO - 微信消息模板对象
     */
    void sendWeChatDefaultNotification ( WechatTemplateDto[] wechatTemplateDTO );

}