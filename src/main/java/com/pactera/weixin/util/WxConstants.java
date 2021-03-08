package com.pactera.weixin.util;

public class WxConstants {


    //public static final String APPID = "wx1f48f6b6c9e403e1";
    public static final String APPID ="ww4c2160c342f61d4c";
    public static final String SECRET = "MmsAw-Ej31jhetK6-LU3vzkTRp9284c9Eo3PEsZDqrE";
    //public static final String SECRET = "zteqo96rP9Zh7-RiuKbT05sKR2gm491kzN0Mkp9yZio";

    /*public static final String APPID = "wx1f48f6b6c9e403e1";
    public static final String SECRET = "zteqo96rP9Zh7-RiuKbT05sKR2gm491kzN0Mkp9yZio";*/


   /* public static final String APPID = "ww4c2160c342f61d4c";
    public static final String SECRET = "MmsAw-Ej31jhetK6-LU3v9S9g60TyOcly5HjnxR9KVw";*/


    //获取微信token
    public static final String QY_GET_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    //获取应用列表
    public static final String QY_GET_APPLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/list";
    //获取菜单
    public static final String QY_GET_MENUS_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/get";
    //创建菜单
    public static final String QY_POST_CREATEMENUS_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/create";
    //删除菜单
    public static final String QY_GET_DELMENUS_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/delete";
    //读取成员
    public static final String QY_GET_USERINFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get";
    //获取成员信息
    public static final String QY_GET_GETUSERINFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
    //获取code
    public static final String WEB_GETCODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

    public static final String QY_GET_GETUSERINFO_URL_1 = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";

    public static final String QY_GET_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list";


    //菜单信息
    public static String WX_MENUS = "{\"button\":[{" + "\"type\": \"view\"," +
            "\"name\": \"应用入口\"," + "\"key\": \"http://www.baidu.com\"," +
            "\"sub_button\": []," + "\"url\": \"http://www.baidu.com\"" +
            "}, {" + "\"name\": \"职场WIFI\"," + "\"sub_button\": [{" +
            "\"type\": \"click\"," + "\"name\": \"WIFI\"," + "\"key\": \"ceshi\"," +
            "\"sub_button\": []" + "}, {" + "\"type\": \"click\"," + "\"name\": \"帮助\"," +
            "\"key\": \"help\"," + "\"sub_button\": []" + "}]" + "}, {" +
            "\"type\": \"view\"," + "\"name\": \"新核心\"," +
            "\"key\": \"http://www.bjpabank.com/bjfhwgj_xhx/yyq/yyqlogin.jsp?UserID=liushsh\"," +
            "\"sub_button\": []," +
            "\"url\": \"http://www.bjpabank.com/bjfhwgj_xhx/yyq/yyqlogin.jsp?UserID=liushsh\"" +
            "}]}";
}
