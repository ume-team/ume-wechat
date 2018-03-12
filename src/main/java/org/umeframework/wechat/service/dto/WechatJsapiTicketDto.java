/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.dto;

/**
 * WechatJsapiTicketDTO 微信JS接口的临时票据对象
 * 包含微信JS接口的临时票据或访问错误代码等信息的封装对象
 *
 * @author DORA generator
 */
public class WechatJsapiTicketDto implements java.io.Serializable, Comparable<WechatJsapiTicketDto> {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * ticket - 微信JS接口的临时票据
    */
    private String ticket;
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
    * Get the "微信JS接口的临时票据"
    */
    public String getTicket () {
        return this.ticket;
    }
   /**
    * Set the "微信JS接口的临时票据"
    */
    public void setTicket (
            String ticket) {
        this.ticket = ticket;
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
            WechatJsapiTicketDto compareToDTO) {
        // default 0 no support sort
        return 0;
    }
}