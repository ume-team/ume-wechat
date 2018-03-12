/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.dto;

/**
 * WechatBaseAccTokenDTO 微信基础访问凭证对象
 * 包含微信基础访问凭证的属性或访问错误代码等信息的封装对象
 *
 * @author DORA generator
 */
public class WechatBaseAccTokenDto implements java.io.Serializable, Comparable<WechatBaseAccTokenDto> {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * access_token - 微信访问凭证
    */
    private String access_token;
   /**
    * expires_in - 凭证有效时间，单位：秒
    */
    private Integer expires_in;
   /**
    * errcode - 错误代码
    */
    private Integer errcode;
   /**
    * errmsg - 错误信息
    */
    private String errmsg;
   /**
    * refreshTime - 取得时间
    */
    private Long refreshTime;
   /**
    * remark - 备考
    */
    private String remark;

   /**
    * Get the "微信访问凭证"
    */
    public String getAccess_token () {
        return this.access_token;
    }
   /**
    * Set the "微信访问凭证"
    */
    public void setAccess_token (
            String access_token) {
        this.access_token = access_token;
    }

   /**
    * Get the "凭证有效时间，单位：秒"
    */
    public Integer getExpires_in () {
        return this.expires_in;
    }
   /**
    * Set the "凭证有效时间，单位：秒"
    */
    public void setExpires_in (
            Integer expires_in) {
        this.expires_in = expires_in;
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
    * Get the "取得时间"
    */
    public Long getRefreshTime () {
        return this.refreshTime;
    }
   /**
    * Set the "取得时间"
    */
    public void setRefreshTime (
            Long refreshTime) {
        this.refreshTime = refreshTime;
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
            WechatBaseAccTokenDto compareToDTO) {
        // default 0 no support sort
        return 0;
    }
}