/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.dto;

/**
 * WechatWebAccTokenDTO 微信网页授权访问凭证对象
 * 包含微信网页授权访问凭证的属性或访问错误代码等信息的封装对象
 *
 * @author DORA generator
 */
public class WechatWebAccTokenDto implements java.io.Serializable, Comparable<WechatWebAccTokenDto> {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * access_token - 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    */
    private String access_token;
   /**
    * expires_in - access_token接口调用凭证超时时间，单位（秒）
    */
    private Integer expires_in;
   /**
    * refresh_token - 用户刷新access_token
    */
    private String refresh_token;
   /**
    * openid - 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
    */
    private String openid;
   /**
    * scope - 用户授权的作用域，使用逗号（,）分隔
    */
    private String scope;
   /**
    * errcode - 错误代码
    */
    private Integer errcode;
   /**
    * errmsg - 错误信息
    */
    private String errmsg;
   /**
    * remark - 备考
    */
    private String remark;

   /**
    * Get the "网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同"
    */
    public String getAccess_token () {
        return this.access_token;
    }
   /**
    * Set the "网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同"
    */
    public void setAccess_token (
            String access_token) {
        this.access_token = access_token;
    }

   /**
    * Get the "access_token接口调用凭证超时时间，单位（秒）"
    */
    public Integer getExpires_in () {
        return this.expires_in;
    }
   /**
    * Set the "access_token接口调用凭证超时时间，单位（秒）"
    */
    public void setExpires_in (
            Integer expires_in) {
        this.expires_in = expires_in;
    }

   /**
    * Get the "用户刷新access_token"
    */
    public String getRefresh_token () {
        return this.refresh_token;
    }
   /**
    * Set the "用户刷新access_token"
    */
    public void setRefresh_token (
            String refresh_token) {
        this.refresh_token = refresh_token;
    }

   /**
    * Get the "用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID"
    */
    public String getOpenid () {
        return this.openid;
    }
   /**
    * Set the "用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID"
    */
    public void setOpenid (
            String openid) {
        this.openid = openid;
    }

   /**
    * Get the "用户授权的作用域，使用逗号（,）分隔"
    */
    public String getScope () {
        return this.scope;
    }
   /**
    * Set the "用户授权的作用域，使用逗号（,）分隔"
    */
    public void setScope (
            String scope) {
        this.scope = scope;
    }

   /**
    * Get the "错误代码"
    */
    public Integer getErrcode () {
        return this.errcode;
    }
   /**
    * Set the "错误代码"
    */
    public void setErrcode (
            Integer errcode) {
        this.errcode = errcode;
    }

   /**
    * Get the "错误信息"
    */
    public String getErrmsg () {
        return this.errmsg;
    }
   /**
    * Set the "错误信息"
    */
    public void setErrmsg (
            String errmsg) {
        this.errmsg = errmsg;
    }

   /**
    * Get the "备考"
    */
    public String getRemark () {
        return this.remark;
    }
   /**
    * Set the "备考"
    */
    public void setRemark (
            String remark) {
        this.remark = remark;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable
     */
    @Override
    public int compareTo(
            WechatWebAccTokenDto compareToDTO) {
        // default 0 no support sort
        return 0;
    }
}