/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.dto;

/**
 * WechatJsapiSignatureDTO 微信JSAPI接口权限验证信息对象
 * 包含为了调用微信JSAPI需要注入的权限验证信息
 *
 * @author DORA generator
 */
public class WechatJsapiSignatureDto implements java.io.Serializable, Comparable<WechatJsapiSignatureDto> {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * appId - 微信公众号ID
    */
    private String appId;
   /**
    * timestamp - 生成签名的时间戳
    */
    private String timestamp;
   /**
    * nonceStr - 生成签名的随机串
    */
    private String nonceStr;
   /**
    * signature - 签名
    */
    private String signature;

   /**
    * Get the "微信公众号ID"
    */
    public String getAppId () {
        return this.appId;
    }
   /**
    * Set the "微信公众号ID"
    */
    public void setAppId (
            String appId) {
        this.appId = appId;
    }

   /**
    * Get the "生成签名的时间戳"
    */
    public String getTimestamp () {
        return this.timestamp;
    }
   /**
    * Set the "生成签名的时间戳"
    */
    public void setTimestamp (
            String timestamp) {
        this.timestamp = timestamp;
    }

   /**
    * Get the "生成签名的随机串"
    */
    public String getNonceStr () {
        return this.nonceStr;
    }
   /**
    * Set the "生成签名的随机串"
    */
    public void setNonceStr (
            String nonceStr) {
        this.nonceStr = nonceStr;
    }

   /**
    * Get the "签名"
    */
    public String getSignature () {
        return this.signature;
    }
   /**
    * Set the "签名"
    */
    public void setSignature (
            String signature) {
        this.signature = signature;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable
     */
    @Override
    public int compareTo(
            WechatJsapiSignatureDto compareToDTO) {
        // default 0 no support sort
        return 0;
    }
}