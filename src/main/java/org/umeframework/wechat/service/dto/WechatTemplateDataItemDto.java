/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.dto;

/**
 * WechatTemplateDataItemDTO 微信消息模板数据属性
 * 微信消息模板数据属性
 *
 * @author DORA generator
 */
public class WechatTemplateDataItemDto implements java.io.Serializable, Comparable<WechatTemplateDataItemDto> {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * value - 值
    */
    private String value;
   /**
    * color - 颜色
    */
    private String color= "#0000FF";

   /**
    * Get the "值"
    */
    public String getValue () {
        return this.value;
    }
   /**
    * Set the "值"
    */
    public void setValue (
            String value) {
        this.value = value;
    }

   /**
    * Get the "颜色"
    */
    public String getColor () {
        return this.color;
    }
   /**
    * Set the "颜色"
    */
    public void setColor (
            String color) {
        this.color = color;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable
     */
    @Override
    public int compareTo(
            WechatTemplateDataItemDto compareToDTO) {
        // default 0 no support sort
        return 0;
    }
}