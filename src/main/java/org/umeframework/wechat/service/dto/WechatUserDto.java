/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.dto;

/**
 * WechatUserDTO 微信用户基础信息传输对象
 * 包含调用微信API获取的各个微信用户基础属性
 *
 * @author DORA generator
 */
public class WechatUserDto implements java.io.Serializable, Comparable<WechatUserDto> {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * openid - 微信平台openid
    */
    private String openid;
   /**
    * nickname - 微信昵称
    */
    private String nickname;
   /**
    * sex - 微信用户性别
    */
    private String sex;
   /**
    * language - 微信用户语言
    */
    private String language;
   /**
    * city - 微信用户城市
    */
    private String city;
   /**
    * province - 微信用户所属省份
    */
    private String province;
   /**
    * country - 微信用户所属国家
    */
    private String country;
   /**
    * headimgurl - 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
    */
    private String headimgurl;
   /**
    * privilege - 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
    */
    private String[] privilege;
   /**
    * unionid - 微信平台unionid
    */
    private String unionid;
   /**
    * subscribe - 订阅信息
    */
    private Integer subscribe;
   /**
    * subscribe_time - 订阅时间
    */
    private Long subscribe_time;
   /**
    * groupid - 分组信息
    */
    private Integer groupid;
   /**
    * tagid_list - 标签列表
    */
    private Integer[] tagid_list;
   /**
    * remark - 备注信息（非微信属性）
    */
    private String remark;

   /**
    * Get the "微信平台openid"
    */
    public String getOpenid () {
        return this.openid;
    }
   /**
    * Set the "微信平台openid"
    */
    public void setOpenid (
            String openid) {
        this.openid = openid;
    }

   /**
    * Get the "微信昵称"
    */
    public String getNickname () {
        return this.nickname;
    }
   /**
    * Set the "微信昵称"
    */
    public void setNickname (
            String nickname) {
        this.nickname = nickname;
    }

   /**
    * Get the "微信用户性别"
    */
    public String getSex () {
        return this.sex;
    }
   /**
    * Set the "微信用户性别"
    */
    public void setSex (
            String sex) {
        this.sex = sex;
    }

   /**
    * Get the "微信用户语言"
    */
    public String getLanguage () {
        return this.language;
    }
   /**
    * Set the "微信用户语言"
    */
    public void setLanguage (
            String language) {
        this.language = language;
    }

   /**
    * Get the "微信用户城市"
    */
    public String getCity () {
        return this.city;
    }
   /**
    * Set the "微信用户城市"
    */
    public void setCity (
            String city) {
        this.city = city;
    }

   /**
    * Get the "微信用户所属省份"
    */
    public String getProvince () {
        return this.province;
    }
   /**
    * Set the "微信用户所属省份"
    */
    public void setProvince (
            String province) {
        this.province = province;
    }

   /**
    * Get the "微信用户所属国家"
    */
    public String getCountry () {
        return this.country;
    }
   /**
    * Set the "微信用户所属国家"
    */
    public void setCountry (
            String country) {
        this.country = country;
    }

   /**
    * Get the "用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空"
    */
    public String getHeadimgurl () {
        return this.headimgurl;
    }
   /**
    * Set the "用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空"
    */
    public void setHeadimgurl (
            String headimgurl) {
        this.headimgurl = headimgurl;
    }

   /**
    * Get the "用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）"
    */
    public String[] getPrivilege () {
        return this.privilege;
    }
   /**
    * Set the "用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）"
    */
    public void setPrivilege (
            String[] privilege) {
        this.privilege = privilege;
    }

   /**
    * Get the "微信平台unionid"
    */
    public String getUnionid () {
        return this.unionid;
    }
   /**
    * Set the "微信平台unionid"
    */
    public void setUnionid (
            String unionid) {
        this.unionid = unionid;
    }

   /**
    * Get the "订阅信息"
    */
    public Integer getSubscribe () {
        return this.subscribe;
    }
   /**
    * Set the "订阅信息"
    */
    public void setSubscribe (
            Integer subscribe) {
        this.subscribe = subscribe;
    }

   /**
    * Get the "订阅时间"
    */
    public Long getSubscribe_time () {
        return this.subscribe_time;
    }
   /**
    * Set the "订阅时间"
    */
    public void setSubscribe_time (
            Long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

   /**
    * Get the "分组信息"
    */
    public Integer getGroupid () {
        return this.groupid;
    }
   /**
    * Set the "分组信息"
    */
    public void setGroupid (
            Integer groupid) {
        this.groupid = groupid;
    }

   /**
    * Get the "标签列表"
    */
    public Integer[] getTagid_list () {
        return this.tagid_list;
    }
   /**
    * Set the "标签列表"
    */
    public void setTagid_list (
            Integer[] tagid_list) {
        this.tagid_list = tagid_list;
    }

   /**
    * Get the "备注信息（非微信属性）"
    */
    public String getRemark () {
        return this.remark;
    }
   /**
    * Set the "备注信息（非微信属性）"
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
            WechatUserDto compareToDTO) {
        // default 0 no support sort
        return 0;
    }
}