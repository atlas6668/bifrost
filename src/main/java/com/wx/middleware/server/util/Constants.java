/**
 * <p>Title: Constants.java</p>
 * <p>微信中间件配置常量</p>
 * @author damon
 * @date 2015年1月23日
 * @version 1.0
 */
package com.wx.middleware.server.util;

/**
 * <p>Title: Constants</p>
 * <p>微信中间件配置常量</p> 
 * @author damon
 * @date 2015年1月23日
 */
public class Constants {

	// -- ---------------------------------------------------------------- --//
	// -- 微信平台 公众号开发方案
	// -- ---------------------------------------------------------------- --//
	public static final String TOKEN = "tangchaokeji";
	// 总数需要43位
	// 唐超(北京)科技(tangchao888beijing888keji8888888) 32位
	// 有限公司(yxgs) 4位
	// 补充码(8888888) 7位
	public static final String ENCODINGAESKEY = "tangchao888beijing888keji8888888yxgs8888888";

	public static final String APPID = "wxd2191838e7571317";

	public static final String SECRET = "6efae614be867c5bc6635fc6969e819e";

	public static final String GRANT_TYPE_CLIENT = "client_credential";
	
	public static final String GRANT_TYPE_AUTH = "authorization_code";
	
	public static final String GRANT_TYPE_JSAPI = "jsapi";
	
	public static final String SCOPE_SNSAPI_BASE = "snsapi_base";
	
	public static final String SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";


	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
  	//-- 							消息类型
	//-- ---------------------------------------------------------------- --// 
  	//-- ---------------------------------------------------------------- --//
	/** 
     * 消息类型：文本
     */
	public static final String WX_MESSAGE_TYPE_TEXT = "text";
	
	/** 
     * 消息类型：图片
     */
	public static final String WX_MESSAGE_TYPE_IMAGE = "image";
	
	/** 
     * 消息类型：语音
     */
	public static final String WX_MESSAGE_TYPE_VOICE = "voice";
	
	/** 
     * 消息类型：视频
     */
	public static final String WX_MESSAGE_TYPE_VIDEO = "video";
	
	/** 
     * 消息类型：地理位置
     */
	public static final String WX_MESSAGE_TYPE_LOCATION = "location";
	
	/** 
     * 消息类型：链接
     */
	public static final String WX_MESSAGE_TYPE_LINK = "link";
	
	/** 
     * 消息类型：事件 
     */ 
	public static final String WX_MESSAGE_TYPE_EVENT = "event"; 
	
	/**
	 * 消息类型：音乐
	 */
	public static final String WX_MESSAGE_TYPE_MUSIC = "music";
	
	/**
	 * 消息类型：图文 
	 */
	public static final String WX_MESSAGE_TYPE_NEWS = "news";
	
	
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --// 
  	//-- 							事件类型
	//-- ---------------------------------------------------------------- --// 
  	//-- ---------------------------------------------------------------- --//
    /** 
     * 事件类型：关注
     */  
    public static final String WX_MESSAGE_EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：取消关注 
     */  
    public static final String WX_MESSAGE_EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    
	/**
	 * 事件类型： 扫描
	 */
	public static final String WX_MESSAGE_EVENT_TYPE_SCAN = "SCAN";
    
    /**
     * 事件类型： 地理位置
     */
    public static final String WX_MESSAGE_EVENT_TYPE_LOCATION = "LOCATION";
  
    /** 
     * 事件类型：点击菜单拉取消息 
     */  
    public static final String WX_MESSAGE_EVENT_TYPE_CLICK = "CLICK";
    
    /** 
     * 事件类型：点击菜单跳转链接 
     */  
    public static final String WX_MESSAGE_EVENT_TYPE_VIEW = "VIEW";
    
    
    //-- ---------------------------------------------------------------- --//
  	//-- ---------------------------------------------------------------- --//
	//-- 							自定义菜单按钮类型
  	//-- ---------------------------------------------------------------- --// 
	//-- ---------------------------------------------------------------- --//
    /**
     * 自定义菜单按钮类型 		点击推事件
     */
    public static final String WX_MENU_BUTTON_TYPE_CLICK = "click";
    
    /**
     * 自定义菜单按钮类型 		跳转URL
     */
    public static final String WX_MENU_BUTTON_TYPE_VIEW = "view";
    
    /**
     * 自定义菜单按钮类型 		扫码推事件
     */
    public static final String WX_MENU_BUTTON_TYPE_SCANCODE_PUSH = "scancode_push";
    		
	/**
	 * 自定义菜单按钮类型 		扫码推事件且弹出“消息接收中”提示框
	 */
	public static final String WX_MENU_BUTTON_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
	
	/**
	 * 自定义菜单按钮类型 		弹出系统拍照发图
	 */
	public static final String WX_MENU_BUTTON_TYPE_PIC_SYSPHOTO = "pic_sysphoto";
    
    /**
     * 自定义菜单按钮类型 		弹出拍照或者相册发图
     */
    public static final String WX_MENU_BUTTON_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    		
	/**
	 * 自定义菜单按钮类型 		弹出微信相册发图器
	 */
	public static final String WX_MENU_BUTTON_TYPE_PIC_WEIXIN = "pic_weixin";
	
	/**
	 * 自定义菜单按钮类型 		弹出地理位置选择器
	 */
	public static final String WX_MENU_BUTTON_TYPE_LOCATION_SELECT = "location_select";
	
	
	//-- ---------------------------------------------------------------- --//
  	//-- ---------------------------------------------------------------- --//
	//-- 							二维码类型
  	//-- ---------------------------------------------------------------- --// 
	//-- ---------------------------------------------------------------- --//
	/**
	 * 二维码类型 临时
	 */
	public static final String WX_QRCODE_ACTION_NAME_QR_SCENE = "QR_SCENE";
	
	/**
	 * 二维码类型 永久
	 */
	public static final String WX_QRCODE_ACTION_NAME_QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
	
	/**
	 * 二维码类型 永久的字符串
	 */
	public static final String WX_QRCODE_ACTION_NAME_QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
	
    
    //-- ---------------------------------------------------------------- --//
    //-- ---------------------------------------------------------------- --// 
	//-- 						微信功能服务接口
    //-- ---------------------------------------------------------------- --// 
	//-- ---------------------------------------------------------------- --//
    
    /**
     * 微信功能服务接口 获取access_token
     */
    public static final String WX_GETACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";
    
    /**
     * 微信功能服务接口 获取微信服务器IP地址
     */
    public static final String WX_GETCALLBACKIP = "https://api.weixin.qq.com/cgi-bin/getcallbackip";
    
    /**
     * 微信功能服务接口 新增临时素材
     */
    public static final String WX_MEDIA_UPLOAD = "https://api.weixin.qq.com/cgi-bin/media/upload";
    
    /**
     * 微信功能服务接口 获取临时素材
     */
    public static final String WX_MEDIA_GET = "https://api.weixin.qq.com/cgi-bin/media/get";
    
    /**
     * 微信功能服务接口 新增永久素材
     */
    public static final String WX_MATERIAL_ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news";
    
    /**
     * 微信功能服务接口 获取永久素材
     */
    public static final String WX_MATERIAL_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material";
    
    /**
     * 微信功能服务接口 删除永久素材
     */
    public static final String WX_MATERIAL_DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material";
    
    /**
     * 微信功能服务接口 修改永久图文素材
     */
    public static final String WX_MATERIAL_UPDATE_NEWS = "https://api.weixin.qq.com/cgi-bin/material/update_news";
    
    /**
     * 微信功能服务接口 获取素材总数
     */
    public static final String WX_MATERIAL_GET_MATERIALCOUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount";
    
    /**
     * 微信功能服务接口 获取素材列表
     */
    public static final String WX_MATERIAL_BATCHGET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";
    
    /**
     * 微信功能服务接口 用户管理 用户分组管理 创建分组
     */
    public static final String WX_GROUPS_CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create";
    
    /**
     * 微信功能服务接口 用户管理 用户分组管理 查询所有分组
     */
    public static final String WX_GROUPS_GET = "https://api.weixin.qq.com/cgi-bin/groups/get";
    
    /**
     * 微信功能服务接口 用户管理 用户分组管理 查询用户所在分组
     */
    public static final String WX_GROUPS_GETID = "https://api.weixin.qq.com/cgi-bin/groups/getid";
    
    /**
     * 微信功能服务接口 用户管理 用户分组管理 修改分组名
     */
    public static final String WX_GROUPS_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/update";
    
    /**
     * 微信功能服务接口 用户管理 用户分组管理 移动用户分组
     */
    public static final String WX_GROUPS_MEMBERS_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/update";
    
    /**
     * 微信功能服务接口 用户管理 用户分组管理 批量移动用户分组
     */
    public static final String WX_GROUPS_MEMBERS_BATCHUPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate";
    
    /**
     * 微信功能服务接口 用户管理 设置用户备注名
     */
    public static final String WX_USER_INFO_UPDATEREMARK = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark";
    
    /**
     * 微信功能服务接口 用户管理 获取用户基本信息(UnionID机制)
     */
    public static final String WX_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info";
    
    /**
     * 微信功能服务接口 用户管理 获取用户列表
     */
    public static final String WX_USER_GET = "https://api.weixin.qq.com/cgi-bin/user/get";
    
    /**
     * 微信功能服务接口 用户管理 用户同意授权，获取code
     */
    public static final String WX_CONNECT_OAUTH2_AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize";
    
    /**
     * 微信功能服务接口 用户管理 通过code换取网页授权access_token
     */
    public static final String WX_SNS_OAUTH2_ACCESS_T0KEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    
    /**
     * 微信功能服务接口 用户管理 刷新access_token（如果需要）
     */
    public static final String WX_SNS_OAUTH2_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    
    /**
     * 微信功能服务接口 用户管理 拉取用户信息(需scope为 snsapi_userinfo)
     */
    public static final String WX_SNS_USERINFO = "https://api.weixin.qq.com/sns/userinfo";
    
    /**
     * 微信功能服务接口 用户管理 检验授权凭证（access_token）是否有效
     */
    public static final String WX_SNS_AUTH = "https://api.weixin.qq.com/sns/auth";
    
    /**
     * 微信功能服务接口 自定义菜单创建接口
     */
    public static final String WX_MENU_CREATE = " https://api.weixin.qq.com/cgi-bin/menu/create";
    
    /**
     * 微信功能服务接口 自定义菜单查询接口
     */
    public static final String WX_MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get";
    
    /**
     * 微信功能服务接口 自定义菜单删除接口
     */
    public static final String WX_MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete";
    
    /**
     * 微信功能服务接口 创建二维码ticket
     */
    public static final String WX_QRCODE_CREATE = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    
    /**
     * 微信功能服务接口 通过ticket换取二维码
     */
    public static final String WX_SHOWQRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode";
    
    /**
     * 微信功能服务接口 长链接转短链接接口
     */
    public static final String WX_SHORTURL = "https://api.weixin.qq.com/cgi-bin/shorturl";
    
    /**
     * 微信功能服务接口 获取用户增减数据（getusersummary）
     */
    public static final String WX_DATACUBE_GETUSERSUMMARY = "https://api.weixin.qq.com/datacube/getusersummary";
    
    /**
     * 微信功能服务接口 获取累计用户数据（getusercumulate）
     */
    public static final String WX_DATACUBE_GETUSERCUMULATE = "https://api.weixin.qq.com/datacube/getusercumulate";
    
    /**
     * 微信功能服务接口 获取图文群发每日数据（getarticlesummary）
     */
    public static final String WX_DATACUBE_GETARTICLESUMMARY = "https://api.weixin.qq.com/datacube/getarticlesummary";
    
    /**
     * 微信功能服务接口 获取图文群发总数据（getarticletotal）
     */
    public static final String WX_DATACUBE_GETARTICLETOTAL = "https://api.weixin.qq.com/datacube/getarticletotal";
    
    /**
     * 微信功能服务接口 获取图文统计数据（getuserread）
     */
    public static final String WX_DATACUBE_GETUSERREAD = "https://api.weixin.qq.com/datacube/getuserread";
    
    /**
     * 微信功能服务接口 获取图文统计分时数据（getuserreadhour）
     */
    public static final String WX_DATACUBE_GETUSERREADHOUR = "https://api.weixin.qq.com/datacube/getuserreadhour";
    
    /**
     * 微信功能服务接口 获取图文分享转发数据（getusershare）
     */
    public static final String WX_DATACUBE_GETUSERSHARE = "https://api.weixin.qq.com/datacube/getusershare";
    
    /**
     * 微信功能服务接口 获取图文分享转发分时数据（getusersharehour）
     */
    public static final String WX_DATACUBE_GETUSERSHAREHOUR = "https://api.weixin.qq.com/datacube/getusersharehour";
    
    /**
     * 微信功能服务接口 获取消息发送概况数据（getupstreammsg） 
     */
    public static final String WX_DATACUBE_GETUPSTREAMMSG = "https://api.weixin.qq.com/datacube/getupstreammsg";
    
    /**
     * 微信功能服务接口 获取消息分送分时数据（getupstreammsghour）
     */
    public static final String WX_DATACUBE_GETUPSTREAMMSGHOUR = "https://api.weixin.qq.com/datacube/getupstreammsghour";
    
    /**
     * 微信功能服务接口 获取消息发送周数据（getupstreammsgweek） 
     */
    public static final String WX_DATACUBE_GETUPSTREAMMSGWEEK = "https://api.weixin.qq.com/datacube/getupstreammsgweek";
    
    /**
     * 微信功能服务接口 获取消息发送月数据（getupstreammsgmonth） 
     */
    public static final String WX_DATACUBE_GETUPSTREAMMSGMONTH = "https://api.weixin.qq.com/datacube/getupstreammsgmonth";
    
    /**
     * 微信功能服务接口 获取消息发送分布数据（getupstreammsgdist）
     */
    public static final String WX_DATACUBE_GETUPSTREAMMSGDIST = "https://api.weixin.qq.com/datacube/getupstreammsgdist";
    
    /**
     * 微信功能服务接口 获取消息发送分布周数据（getupstreammsgdistweek）
     */
    public static final String WX_DATACUBE_GETUPSTREAMMSGDISTWEEK = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek";
    
    /**
     * 微信功能服务接口 获取消息发送分布月数据（getupstreammsgdistmonth）
     */
    public static final String WX_DATACUBE_GETUPSTREAMMSGDISTMONTH = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth";
    
    /**
     * 微信功能服务接口 获取接口分析数据（getinterfacesummary）
     */
    public static final String WX_DATACUBE_GETINTERFACESUMMARY = "https://api.weixin.qq.com/datacube/getinterfacesummary";
    
    /**
     * 微信功能服务接口 获取接口分析分时数据（getinterfacesummaryhour） 
     */
    public static final String WX_DATACUBE_GETINTERFACESUMMARYHOUR = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour";
    
    /**
     * 微信功能服务接口 JS-SDK使用权限签名算法 获得jsapi_ticket
     */
    public static final String WX_TICKET_GETTICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    
    /**
     * 微信功能服务接口 语义理解
     */
    public static final String WX_SEMANTIC_SEMPROXY_SEARCH = "https://api.weixin.qq.com/semantic/semproxy/search";
    
    /**
     * 微信功能服务接口 获取客服基本信息
     */
    public static final String WX_CUSTOMSERVICE_GETKFLIST = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist";
    
    /**
     * 微信功能服务接口 获取在线客服接待信息
     */
    public static final String WX_CUSTOMSERVICE_GETONLINEKFLIST = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist";
    
    /**
     * 微信功能服务接口 添加客服账号
     */
    public static final String WX_CUSTOMSERVICE_KFACCOUNT_ADD = "https://api.weixin.qq.com/customservice/kfaccount/add";
    
    /**
     * 微信功能服务接口 设置客服信息
     */
    public static final String WX_CUSTOMSERVICE_LFACCOUNT_UPDATE = "https://api.weixin.qq.com/customservice/kfaccount/update";
    
    /**
     * 微信功能服务接口 上传客服头像
     */
    public static final String WX_CUSTOMSERVICE_KFACCOUNT_UPLOADHEADIMG = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg";
    
    /**
     * 微信功能服务接口 删除客服账号
     */
    public static final String WX_CUSTOMSERVICE_KFACCOUNT_DEL = "https://api.weixin.qq.com/customservice/kfaccount/del";
    
    /**
     * 微信功能服务接口 多客服会话控制 创建会话
     */
    public static final String WX_CUSTOMSERVICE_KFSESSION_CREATE = " https://api.weixin.qq.com/customservice/kfsession/create";
    
    /**
     * 微信功能服务接口 多客服会话控制 关闭会话
     */
    public static final String WX_CUSTOMSERVICE_KFSESSION_CLOSE = " https://api.weixin.qq.com/customservice/kfsession/close";
    
    /**
     * 微信功能服务接口 多客服会话控制 获取客户的会话状态
     */
    public static final String WX_CUSTOMSERVICE_KFSESSION_GETSESSION = " https://api.weixin.qq.com/customservice/kfsession/getsession";
    
    /**
     * 微信功能服务接口 多客服会话控制 获取客服的会话列表
     */
    public static final String WX_CUSTOMSERVICE_KFSESSION_GETSESSIONLIST = " https://api.weixin.qq.com/customservice/kfsession/getsessionlist";
    
    /**
     * 微信功能服务接口 多客服会话控制 获取未接入会话列表
     */
    public static final String WX_CUSTOMSERVICE_KFSESSION_GETWAITCASE = "https://api.weixin.qq.com/customservice/kfsession/getwaitcase";
    
    /**
     * 微信功能服务接口 获取客服聊天记录
     */
    public static final String WX_CUSTOMSERVICE_GETRECORD = "https://api.weixin.qq.com/cgi-bin/customservice/getrecord";
    
    
	
}
