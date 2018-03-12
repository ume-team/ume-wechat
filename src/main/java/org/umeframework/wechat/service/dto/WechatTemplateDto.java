/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.dto;

import java.util.Map ;

/**
 * WechatTemplateDTO 微信消息模板对象
 * 微信消息模板对象
 *
 * @author DORA generator
 */
public class WechatTemplateDto implements java.io.Serializable, Comparable<WechatTemplateDto> {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * touser - 消息接受者
    */
    private String touser;
   /**
    * template_id - 模板编号
    */
    private String template_id;
   /**
    * url - 消息打开URL
    */
    private String url;
   /**
    * topcolor - 消息背景色
    */
    private String topcolor= "#FF0000";
   /**
    * data - 消息内容
    */
    private Map<String,WechatTemplateDataItemDto> data;

   /**
    * Get the "消息接受者"
    */
    public String getTouser () {
        return this.touser;
    }
   /**
    * Set the "消息接受者"
    */
    public void setTouser (
            String touser) {
        this.touser = touser;
    }

   /**
    * Get the "模板编号"
    */
    public String getTemplate_id () {
        return this.template_id;
    }
   /**
    * Set the "模板编号"
    */
    public void setTemplate_id (
            String template_id) {
        this.template_id = template_id;
    }

   /**
    * Get the "消息打开URL"
    */
    public String getUrl () {
        return this.url;
    }
   /**
    * Set the "消息打开URL"
    */
    public void setUrl (
            String url) {
        this.url = url;
    }

   /**
    * Get the "消息背景色"
    */
    public String getTopcolor () {
        return this.topcolor;
    }
   /**
    * Set the "消息背景色"
    */
    public void setTopcolor (
            String topcolor) {
        this.topcolor = topcolor;
    }

   /**
    * Get the "消息内容"
    */
    public Map<String,WechatTemplateDataItemDto> getData () {
        return this.data;
    }
   /**
    * Set the "消息内容"
    */
    public void setData (
            Map<String,WechatTemplateDataItemDto> data) {
        this.data = data;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable
     */
    @Override
    public int compareTo(
            WechatTemplateDto compareToDTO) {
        // default 0 no support sort
        return 0;
    }
}