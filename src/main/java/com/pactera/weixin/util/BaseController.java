package com.pactera.weixin.util;

import com.alibaba.fastjson.JSON;
import com.pactera.weixin.model.AccessTokenResult;

import java.util.Date;
import java.util.HashMap;

public class BaseController {

    public static String access_token;
    public static String access_msg;
    public Long access_token_updateTime;

    /**
     * 获取微信token(2个小时更新)
     * @return
     * @throws Exception
     */
    public boolean getToken() throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("corpid", WxConstants.APPID);
        map.put("corpsecret", WxConstants.SECRET);
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_TOKEN_URL, map, "UTF-8");

        AccessTokenResult accessTokenResult= JSON.parseObject(sReMsg, AccessTokenResult.class);
        if ("0".equals(accessTokenResult.getErrcode())) {
            access_token_updateTime = new Date().getTime();
            access_token = accessTokenResult.getAccess_token();
            access_msg = accessTokenResult.getErrcode() + ":" + accessTokenResult.getErrmsg();
            return true;
        } else {
            access_msg = accessTokenResult.getErrcode() + ":" + accessTokenResult.getErrmsg();
            return false;
        }
    }
}
