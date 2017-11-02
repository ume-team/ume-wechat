/*
 * Copyright 2014-2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.wechat.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.umeframework.dora.ajax.AjaxParser;
import org.umeframework.dora.ajax.AjaxRender;
import org.umeframework.dora.exception.ApplicationException;
import org.umeframework.dora.http.HttpProxy;
import org.umeframework.dora.message.MessageProperties;
import org.umeframework.dora.service.BaseComponent;
import org.umeframework.dora.util.DateUtil;
import org.umeframework.dora.util.StringUtil;
import org.umeframework.wechat.message.MessageConst;
import org.umeframework.wechat.service.WechatCommonService;
import org.umeframework.wechat.service.dto.WechatBaseAccTokenDto;
import org.umeframework.wechat.service.dto.WechatJsapiSignatureDto;
import org.umeframework.wechat.service.dto.WechatJsapiTicketDto;
import org.umeframework.wechat.service.dto.WechatTemplateDto;
import org.umeframework.wechat.service.dto.WechatUserDto;
import org.umeframework.wechat.service.dto.WechatWebAccTokenDto;

/**
 * 微信共通管理组件 <br>
 * 提供微信共通的统一管理服务 <br>
 *
 * @author MA YUE
 */
@org.springframework.stereotype.Service
public class WechatCommonServiceImpl extends BaseComponent implements WechatCommonService, MessageConst {
	/**
	 * 常量访问接口<br>
	 */
	@Resource(name = "wechatConfig")
	private MessageProperties wechatConfig;
	/**
	 * HTTP proxy instance
	 */
	@Resource(name = "urlEncodedHttpProxy")
	private HttpProxy urlEncodedHttpProxy;
	/**
	 * JSON解析器<br>
	 */
	@Resource(name = "ajaxParser")
	private AjaxParser<String> ajaxParser;

	/**
	 * JSON生成器<br>
	 */
	@Resource(name = "ajaxRender")
	private AjaxRender<String> ajaxRender;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.antu.ci.service.com.WechatCommonService#getWechatJsapiSignature(java. lang.String)
	 */
	@Override
	public WechatJsapiSignatureDto getWechatJsapiSignature(String url) {
		WechatJsapiSignatureDto result = new WechatJsapiSignatureDto();
		String ticket = getWechatJsapiTicket(getAccessToken());
		String nonceStr = UUID.randomUUID().toString();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		String signature = null;

		// 注意这里参数名必须全部小写，且必须有序
		String signatureString = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
		getLogger().info("微信js签名字符串(before): " + signatureString);

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(signatureString.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		getLogger().info("微信js签名sign: " + signature);

		result.setAppId(getConst("WECHAT-APPID"));
		result.setNonceStr(nonceStr);
		result.setTimestamp(timestamp);
		result.setSignature(signature);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.umeframework.dora.service.wx.WechatCommonService#getWechatJsapiTicket(java.lang.String)
	 */
	public String getWechatJsapiTicket(String accessToken) {
		// TODO check ticket expire
		String url = getConst("WECHAT-GET-JSAPI-TICKET-URL");
		url = url.replace("{accessToken}", accessToken);
		String jsonData = urlEncodedHttpProxy.doGet(url);
		WechatJsapiTicketDto result = this.parseJson(jsonData, WechatJsapiTicketDto.class);
		super.getLogger().info("Wechat jsapi ticket refresh.");
		return result.getTicket();
	}
	
    /*
     * (non-Javadoc)
     * 
     * @see cn.antu.ci.service.com.WechatCommonService#queryAccessToken(java.lang. String)
     */
    @Override
    public String getAccessToken() {
        String accessToken = null;

        String appid = getConst("WECHAT-APPID");
        String secretKey = getConst("WECHAT-APPSECRET");
        WechatBaseAccTokenDto accessTokenDTO = refreshAccessToken(appid, secretKey);
        accessToken = accessTokenDTO.getAccess_token();

        if (accessToken == null) {
            throw new ApplicationException(UME_WECHAT_MSG_201);
        }
        return accessToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.umeframework.dora.service.wx.WechatCommonService#refreshAccessToken(java.lang.String, java.lang.String)
     */
    public WechatBaseAccTokenDto refreshAccessToken(String appid, String secretKey) {
        String url = getConst("WECHAT-GET-ACC-TOKEN-CGIURL");
        url = url.replace("{appid}", appid);
        url = url.replace("{secret}", secretKey);

        String jsonData = urlEncodedHttpProxy.doGet(url);
        WechatBaseAccTokenDto accessTokenDTO = this.parseJson(jsonData, WechatBaseAccTokenDto.class);
        super.getLogger().info("Wechat access token refresh.");
        return accessTokenDTO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.antu.ci.service.com.WechatCommonService#getWechatWebAccTokenDTO(java.lang.String)
     */
    public WechatWebAccTokenDto getWechatWebAccTokenDTO(String accessCode) {
        String appid = getConst("WECHAT-APPID");
        String secret = getConst("WECHAT-APPSECRET");
        String url = getConst("WECHAT-GET-ACC-TOKEN-URL");
        url = url.replace("{appid}", appid);
        url = url.replace("{secret}", secret);
        url = url.replace("{accessCode}", accessCode);
        String jsonText = urlEncodedHttpProxy.doGet(url);
        WechatWebAccTokenDto accessTokenDTO = this.parseJson(jsonText, WechatWebAccTokenDto.class);
        if (accessTokenDTO == null || accessTokenDTO.getOpenid() == null) {
            throw new ApplicationException(UME_WECHAT_MSG_302);
        }
        return accessTokenDTO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.antu.ci.service.com.WechatCommonService#getWechatUserData(java.lang.String, java.lang.String)
     */
    public WechatUserDto getWechatUserData(String openid, String accessToken) {
        // 通过CGI接口、获取用户基本信息
        String urlCgi = getConst("WECHAT-GET-USER-CGIURL");
        urlCgi = urlCgi.replace("{openid}", openid);

        urlCgi = urlCgi.replace("{accessToken}", accessToken);
        super.getLogger().info("wechatCommonService is " + urlCgi);
        String jsonText = urlEncodedHttpProxy.doGet(urlCgi);
        WechatUserDto weChatUserDTO = this.parseJson(jsonText, WechatUserDto.class);
        return weChatUserDTO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.antu.ci.service.com.WechatCommonService#sendWeChatDefaultNotification(cn.antu.ci.service.com.dto.WechatTemplateDTO[])
     */
    @Override
    public void sendWeChatDefaultNotification(WechatTemplateDto[] wechatTemplateDTO) {
        String wechatPostTmplMsgUrl = getConst("WECHAT-POST-TMPL-MSG-CGIURL");
        wechatPostTmplMsgUrl = wechatPostTmplMsgUrl.replace("{accessToken}", getAccessToken());
        for (WechatTemplateDto wechatdto : wechatTemplateDTO) {
            String data = this.renderJson(wechatdto);
            urlEncodedHttpProxy.doPost(wechatPostTmplMsgUrl, data);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.antu.ci.service.com.WechatCommonService#downloadWechatTmpRes(java.lang .String, java.lang.String[])
     */
    @Override
    public String[] downloadWechatTmpRes(String category, String[] ids) {
        // 默认素材为media信息，暂时未使用"category"
        List<String> result = new ArrayList<String>(ids.length);
        // 取得微信素材临时存贮访问接口
        String urlCgi = getConst("WECHAT-GET-MEDIA-CGIURL");
        // 取得本地存放路径
        String saveToRootPath = getConst("WECHAT-LOCAL-MEDIA-SAVE-PATH");
        saveToRootPath = saveToRootPath.endsWith("/") ? saveToRootPath : saveToRootPath + "/";
        urlCgi = urlCgi.replace("{accessToken}", getAccessToken());
        for (String id : ids) {
            if (StringUtil.isEmpty(id)) {
                result.add("");
                continue;
            }
            String url = urlCgi.replace("{mediaId}", id);
            // 以当前日期分别建立存放子目录
            String subPath = DateUtil.dateToString(super.getCurrentTimestamp(), DateUtil.FORMAT.YYMMDD) + "/";

            File path = new File(saveToRootPath + subPath);
            if (!path.exists()) {
                path.mkdirs();
            }
            String fileName = id + ".jpg";
            File file = new File(saveToRootPath + subPath + fileName);
            if (file.exists()) {
                file.delete();
            }
            long downloadSize = this.urlEncodedHttpProxy.doDownload(url, saveToRootPath + subPath + fileName, null, null);
            if (downloadSize == 0) {
                result.add("");
                super.getLogger().warn("Downlod file size is 0, file name:" + fileName);
            }
            result.add(subPath + fileName);
        }
        return result.toArray(new String[result.size()]);
    }

    /**
     * 根据键值读取动态常量(带下标定义的常量)内容<br>
     * 例如:当sysId为"s01"情况下，Const中定义如下两个常量<br>
     * 1) WECHAT-APPID = a01<br>
     * 2) WECHAT-APPID[s01] = a02<br>
     * 此时getConst讲返回"a02",如果2)未定义则返回"a01"<br>
     * <br>
     * 
     * @param key
     *            - 常量键值
     * @return 内容文本
     */
    protected String getConst(String key) {
        String sysId = super.getSysId();
        String value = wechatConfig.get(key + "[" + sysId + "]");
        if (StringUtil.isEmpty(value)) {
            value = wechatConfig.get(key);
        }
        if (StringUtil.isEmpty(value)) {
            throw new ApplicationException(UME_WECHAT_MSG_203, new Object[] {key});
        }
        return value;
    }

    /**
     * 解析JSON数据到目标Java对象<br>
     * 
     * @param jsonStr
     *            - JSON文本
     * @param clazz
     *            - 目标对象类型
     * @return
     */
    protected <E> E parseJson(String jsonStr, Class<E> clazz) {
        E obj = null;
        try {
            obj = ajaxParser.parse(jsonStr, clazz, null, null);
        } catch (Exception ex) {
            throw new ApplicationException(UME_WECHAT_MSG_201, new Object[] {clazz.getSimpleName()});
        }
        return obj;
    }

    /**
     * 变换Java对象至JSON格式<br>
     * 
     * @param obj
     * @return
     */
    protected <E> String renderJson(E obj) {
        String jsonStr = null;
        try {
            jsonStr = ajaxRender.render(obj);
        } catch (Exception ex) {
            throw new ApplicationException(UME_WECHAT_MSG_202, new Object[] {obj != null ? obj.getClass() : obj});
        }
        return jsonStr;
    }

    /**
     * byteToHex
     * 
     * @param hash
     * @return
     */
    protected String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }


}
