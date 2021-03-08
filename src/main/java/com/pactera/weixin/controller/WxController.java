package com.pactera.weixin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pactera.weixin.model.AccessTokenResult;
import com.pactera.weixin.util.BaseController;
import com.pactera.weixin.util.WxConstants;
import com.pactera.weixin.util.WxHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * 类名称: WxController
 * 类描述: 调用微信接口
 * 创建时间:2018年10月25日上午10:52:13
 */
@RestController
@RequestMapping("/weixin")
public class WxController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(WxController.class);
    /**
     * 获取微信token(2个小时更新)
     * @return
     * @throws Exception
     */
    @GetMapping("/getAccessToken")
    public String getAccessToken() throws Exception {
        if (access_token != null && (access_token_updateTime + 5400000) > new Date().getTime())
            return access_token;

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("corpid", WxConstants.APPID);
        map.put("corpsecret", WxConstants.SECRET);
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_TOKEN_URL, map, "UTF-8");

        AccessTokenResult accessTokenResult= JSON.parseObject(sReMsg, AccessTokenResult.class);
        if ("0".equals(accessTokenResult.getErrcode())) {
            access_token_updateTime = new Date().getTime();
            access_token = accessTokenResult.getAccess_token();
            return access_token;
        } else {
            return accessTokenResult.getErrcode()+":"+accessTokenResult.getErrmsg();
        }
    }

    /**
     * 获取应用列表
     * @return
     * @throws Exception
     */
    @GetMapping("/getAppList")
    public String getAppList() throws Exception {
        if (access_token == null || "".equals(access_token) ||
                (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_APPLIST_URL, map, "UTF-8");
        return sReMsg;
    }

    /**
     * 获取菜单
     * @return
     * @throws Exception
     */
    @GetMapping("/getMenus")
    public String getMenus() throws Exception {
        if (access_token == null || "".equals(access_token) ||
                (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("agentid", 30);
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_MENUS_URL, map, "UTF-8");
        return sReMsg;
    }

    /**
     * 删除菜单
     * @return
     * @throws Exception
     */
    @GetMapping("/delMenus")
    public String delMenus() throws Exception {
        if (access_token == null || "".equals(access_token) ||
                (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("agentid", 30);
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_DELMENUS_URL, map, "UTF-8");
        return sReMsg;
    }


    /**
     * 创建菜单
     * @return
     * @throws Exception
     */
    @PostMapping("/createMenus")
    public String createMenus() throws Exception {
        if (access_token == null || "".equals(access_token) ||
                (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("agentid", 30);
        map.put("body", WxConstants.WX_MENUS);
        String sReMsg = WxHttpRequest.sendPost(WxConstants.QY_POST_CREATEMENUS_URL, map, "UTF-8");
        return sReMsg;
    }


    /**
     * 读取成员
     * @return
     * @throws Exception
     */
    @GetMapping("/getUserInfo")
    public String getUserInfo() throws Exception {
        if (access_token == null || "".equals(access_token) ||
                (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("userid", "wangjiejun");
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_USERINFO_URL, map, "UTF-8");
        return sReMsg;
    }


    /**
     * 获取成员信息
     * @return
     * @throws Exception
     */
    @GetMapping("/getUserInfoFromCode")
    public String getUserInfoFromCode() throws Exception {
        if (access_token == null || "".equals(access_token) ||
                (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("code", "code");
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_GETUSERINFO_URL, map, "UTF-8");
        return sReMsg;
    }

    /**
     * 获取部门列表
     * @return
     * @throws Exception
     */
    @GetMapping("/getDepartmentList")
    public String getDepartmentList() throws Exception {
        if (access_token == null || "".equals(access_token) ||
                (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("id", "10");
        String sReMsg = WxHttpRequest.sendGet(WxConstants.QY_GET_DEPARTMENT_URL, map, "UTF-8");
        return sReMsg;
    }

    /**
     * 获取通过OAuth获取用户基本信息
     * @return
     * @throws Exception
     *
     * 通过OAuth2.0验证接口获取成员身份会有一定的时间开销。对于频繁获取成员身份的场景，建议采用如下方案：
     * 1、企业应用中的URL链接直接填写企业自己的页面地址
     * 2、成员操作跳转到步骤1的企业页面时，企业后台校验是否有标识成员身份的cookie信息，此cookie由企业生成
     * 3、如果没有匹配的cookie，则重定向到OAuth验证链接，获取成员的身份信息后，由企业后台植入标识成员身份的cookie信息
     * 4、根据cookie获取成员身份后，再进入相应的页面
     */
    @RequestMapping("/getUserInfofromOAuth")
    public void getUserInfofromOAuth(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {
        String code = req.getParameter("code");
        if (access_token == null || "".equals(access_token) ||
            (access_token_updateTime + 5400000) <= new Date().getTime()) {
            getToken();
        }

        //获取UserId
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("code", code);
        JSONObject jsonObject = JSON.parseObject(WxHttpRequest.sendGet(WxConstants.QY_GET_GETUSERINFO_URL_1, map, "UTF-8"));
        if("0".equals(jsonObject.getString("errcode"))){
            //获取用户基本信息：用户名、用户id、部门id
            map = new HashMap<String, Object>();
            map.put("access_token", access_token);
            map.put("userid", jsonObject.getString("UserId"));
            jsonObject = JSON.parseObject(WxHttpRequest.sendGet(WxConstants.QY_GET_USERINFO_URL, map, "UTF-8"));
            if("0".equals(jsonObject.getString("errcode"))){
                //获取用户所属部门名称
                map = new HashMap<String, Object>();
                map.put("access_token", access_token);
                map.put("id", jsonObject.getJSONArray("department").get(0));
                jsonObject = JSON.parseObject(WxHttpRequest.sendGet(WxConstants.QY_GET_DEPARTMENT_URL, map, "UTF-8"));
                if("0".equals(jsonObject.getString("errcode"))){
                    Object obj = jsonObject.getJSONArray("department").get(0);
                    req.getSession().setAttribute("dep_name", obj);
                    req.getSession().setAttribute("userid",jsonObject.getString("userid"));
                    req.getSession().setAttribute("username",jsonObject.getString("name"));
                    resp.sendRedirect(req.getContextPath() + "/demo/hello");
                }
            }
        }

        resp.sendRedirect(req.getContextPath() + "/demo/error");
    }
}