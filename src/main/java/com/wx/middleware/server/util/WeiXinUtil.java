/**
 * <p>Title: WeiXinUtil.java</p>
 * <p>微信工具类</p>
 * @author damon
 * @date 2014年12月18日
 * @version 1.0
 */
package com.wx.middleware.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.wx.middleware.server.bean.account.QrcodeRS;
import com.wx.middleware.server.bean.base.AccessToken;
import com.wx.middleware.server.bean.jssdk.JsTicket;
import com.wx.middleware.server.bean.material.MaterialCount;
import com.wx.middleware.server.bean.material.MaterialNews;
import com.wx.middleware.server.bean.material.MaterialOthers;
import com.wx.middleware.server.bean.menu.WxMenuButtonCreateResult;
import com.wx.middleware.server.bean.user.Oauth2;
import com.wx.middleware.server.enums.WxMaterialType;

/**
 * <p>Title: WeiXinUtil</p>
 * <p>微信工具类</p>
 * @author damon
 * @date 2014年12月18日
 * @version 1.0
 */
public class WeiXinUtil {
    
    //-- ---------------------------------------------------------------- --//
    //-- ---------------------------------------------------------------- --//
  	//-- ---------------------------------------------------------------- --//
  	//-- 						微信功能接口
  	//-- ---------------------------------------------------------------- --// 
  	//-- ---------------------------------------------------------------- --//
    //-- ---------------------------------------------------------------- --//
	public static void main(String[] args){
		try {
			String access_token = getAccess_token(Constants.APPID, Constants.SECRET);
			System.out.println(access_token);
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    //-- ---------------------------------------------------------------- --//
  	//-- 						基础接口
  	//-- ---------------------------------------------------------------- --//
    /**
     * <p>getAccess_token</p>
     * <p>获取微信 access_token </p>
     * @author damon
     * @date 2015年1月19日
     * @param appid
     * @param secret
     * @return access_token
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    public static String getAccess_token(String appid, String secret) throws IOException, 
    	KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
    	JSONObject jsonObject = null;
    	StringBuffer sb = new StringBuffer(Constants.WX_GETACCESS_TOKEN);
    	sb.append("?grant_type=").append(Constants.GRANT_TYPE_CLIENT);
    	sb.append("&appid=").append(appid);
    	sb.append("&secret=").append(secret);
    	String url = sb.toString();
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(url, "");
//		System.out.println(jsonObject.toString());
    	@SuppressWarnings("static-access")
    	AccessToken token = jsonObject.toJavaObject(jsonObject, AccessToken.class);
    	return token.getAccess_token();
    }
    
    /**
     * <p>getAccess_token</p>
     * <p>获取微信 access_token 默认微信账号</p>
     * @author damon
     * @date 2014年12月22日
     * @return access_token
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    public static String getAccess_token() throws IOException, KeyManagementException, 
    	NoSuchAlgorithmException, NoSuchProviderException {
    	return getAccess_token(Constants.APPID, Constants.SECRET);
    }
    
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						素材管理接口
  	//-- ---------------------------------------------------------------- --//
    /**
     * <p>get_materialcount</p>
     * <p>获取微信素材总数</p>
     * @author damon
     * @date 2015年3月19日
     * @param access_token
     * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    private static JSONObject get_materialcount(String access_token) throws IOException, 
    	KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
    	JSONObject jsonObject = null;
    	StringBuffer sb = new StringBuffer(Constants.WX_MATERIAL_GET_MATERIALCOUNT);
		sb.append("?access_token=").append(access_token);
		String urlStr = sb.toString();
//		System.out.println("urlStr : "+urlStr);
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(urlStr, "");
//		System.out.println(jsonObject.toString());
    	return jsonObject;
    }
    /**
     * <p>get_materialcountByType</p>
     * <p>根据素材类型获取微信素材总数</p>
     * @author damon
     * @date 2015年3月19日
     * @param access_token
     * @param type
     * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    public static int get_materialcountByType(String access_token, WxMaterialType type) 
    		throws IOException, KeyManagementException, NoSuchAlgorithmException, 
    		NoSuchProviderException {
    	JSONObject jsonObject = get_materialcount(access_token);
    	@SuppressWarnings("static-access")
		MaterialCount count = jsonObject.toJavaObject(jsonObject, MaterialCount.class);
    	switch(type){
    		case IMAGE: return count.getImage_count();
    		case VOICE: return count.getVoice_count();
    		case VIDEO: return count.getVideo_count();
    		case NEWS: return count.getNews_count();
    		default : return count.getImage_count();
    	}
    }
    
    /**
     * <p>batchget_material</p>
     * <p>获取素材列表</p>
     * @author damon
     * @date 2015年3月20日
     * @param access_token
     * @param type
     * @param offset
     * @param count
     * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    private static JSONObject batchget_material(String access_token, 
    		WxMaterialType type, int offset, int count) throws IOException, 
    		KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
    	JSONObject jsonObject = null;
    	StringBuffer sb = new StringBuffer(Constants.WX_MATERIAL_BATCHGET_MATERIAL);
		sb.append("?access_token=").append(access_token);
		String urlStr = sb.toString();
//		System.out.println("urlStr : "+urlStr);
		String content = "{\"type\":\""+getWxMaterialType(type)+"\",\"offset\":"+offset+",\"count\":"+count+"}";
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(urlStr, content);
//		System.out.println(jsonObject.toString());
    	return jsonObject;
    }
    
    /**
     * <p>batchget_material_news</p>
     * <p>批量获取微信素材 图文消息</p>
     * @author damon
     * @date 2015年3月23日
     * @param access_token
     * @param offset
     * @param count
     * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    public static MaterialNews batchget_material_news(String access_token, int offset, int count) 
    		throws IOException, KeyManagementException, NoSuchAlgorithmException, 
    		NoSuchProviderException {
    	JSONObject jsonObject = batchget_material(access_token, WxMaterialType.NEWS, offset, count);
    	@SuppressWarnings("static-access")
    	MaterialNews mn = jsonObject.toJavaObject(jsonObject, MaterialNews.class);
    	return mn;
    }
    
    /**
     * <p>batchget_material_others</p>
     * <p>批量获取微信素材 其他类型（图片、语音、视频）</p>
     * @author damon
     * @date 2015年3月20日
     * @param access_token
     * @param type
     * @param offset
     * @param count
     * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    public static MaterialOthers batchget_material_others(String access_token, 
    		WxMaterialType type, int offset, int count) throws IOException, 
    		KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
    	JSONObject jsonObject = WeiXinUtil.batchget_material(access_token, type, offset, count);
    	@SuppressWarnings("static-access")
		MaterialOthers mo = jsonObject.toJavaObject(jsonObject, MaterialOthers.class);
    	return mo;
    }
    
    public static String get_material(String access_token, String media_id, String pathName) 
    		throws KeyManagementException, NoSuchAlgorithmException, 
    		NoSuchProviderException, IOException {
    	StringBuffer sb = new StringBuffer(Constants.WX_MATERIAL_GET_MATERIAL);
		sb.append("?access_token=").append(access_token);
		String urlStr = sb.toString();
		String content = "{\"media_id\":"+media_id+"}";
//		System.out.println("urlStr : "+urlStr);
		pathName = JavaRequestAndResponse.downloadFileByHttpsUrlDefaultHeader(urlStr, pathName, content);
		System.out.println(pathName);
    	return pathName;
    }
    
    public static String getWxMaterialType(WxMaterialType type) {
    	switch(type){
		case IMAGE: return "image";
		case VOICE: return "voice";
		case VIDEO: return "video";
		case NEWS: return "news";
		default : return "image";
	}
    }

    //-- ---------------------------------------------------------------- --//
  	//-- 						用户管理接口
  	//-- ---------------------------------------------------------------- --//
    /**
     * <p>decorateOauth2Url</p>
     * <p>装饰URL成微信的Oauth2用户授权认证URL</p>
     * @author damon
     * @date 2015年3月19日
     * @param appid
     * @param redirectUri
     * @return
     */
    public static String decorateOauth2Url(String appid, String redirectUri) {
		// 获取微信 Code
		StringBuffer sb = new StringBuffer(Constants.WX_CONNECT_OAUTH2_AUTHORIZE);
		sb.append("?appid=").append(appid);
		sb.append("&redirect_uri=").append(redirectUri);
		sb.append("&response_type=").append("code");
		sb.append("&scope=").append(Constants.SCOPE_SNSAPI_BASE);
		sb.append("&state=").append("1").append("#wechat_redirect");
		String url = sb.toString();
//		System.out.println("url : "+url);
		return url;
	}
    /**
	 * <p>decorateOauth2Url</p>
	 * <p>装饰URL成微信的Oauth2用户授权认证URL    默认账号</p>
	 * @author damon
	 * @date 2014年12月23日
	 * @param redirectUri
	 * @return
	 */
	public static String decorateOauth2Url(String redirectUri) {
		return decorateOauth2Url(Constants.APPID, redirectUri);
	}
	
	/**
	 * <p>getOpenIdByOauth2</p>
	 * <p>通过Oauth2用户授权认证 获取用户OpenId</p>
	 * @author damon
	 * @date 2015年3月19日
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String getOpenIdByOauth2(String appid, String secret, String code) 
			throws IOException, KeyManagementException, NoSuchAlgorithmException, 
			NoSuchProviderException {
		JSONObject jsonObject = null;
		StringBuffer sb = new StringBuffer(Constants.WX_SNS_OAUTH2_ACCESS_T0KEN);
		sb.append("?appid=").append(appid);
		sb.append("&secret=").append(secret);
		sb.append("&code=").append(code);
		sb.append("&grant_type=").append(Constants.GRANT_TYPE_AUTH);
		String url = sb.toString();
//		System.out.println("url : "+url);
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(url, "");
//		System.out.println(jsonObject.toString());
		@SuppressWarnings("static-access")
		Oauth2 oauth2 = jsonObject.toJavaObject(jsonObject, Oauth2.class);
		return oauth2.getOpenid();
	}
	/**
	 * <p>getOpenIdByOauth2</p>
	 * <p>通过Oauth2用户授权认证 获取用户OpenId    默认账号</p>
	 * @author damon
	 * @date 2014年12月23日
	 * @param code
	 * @return
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String getOpenIdByOauth2(String code) throws IOException, 
		KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		return getOpenIdByOauth2(Constants.APPID, Constants.SECRET, code);
	}
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						自定义菜单管理接口
  	//-- ---------------------------------------------------------------- --//
	/**
	 * <p>createMenu</p>
	 * <p>自定义菜单 创建菜单</p>
	 * @author damon
	 * @date 2014年12月22日
	 * @param params
	 * @param access_token
	 * @return errmsg
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String createMenu(String params, String access_token) throws IOException, 
		KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException{
		JSONObject jsonObject = null;
		StringBuffer sb = new StringBuffer(Constants.WX_MENU_CREATE);
		sb.append("?access_token=").append(access_token);
		String url = sb.toString();
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(url, params);
//		System.out.println(jsonObject.toString());
		@SuppressWarnings("static-access")
		WxMenuButtonCreateResult button = jsonObject.toJavaObject(jsonObject, WxMenuButtonCreateResult.class);
		return button.getErrmsg();
	}
	
	/**
	 * <p>deleteMenu</p>
	 * <p>自定义菜单 删除菜单</p>
	 * @author damon
	 * @date 2014年12月23日
	 * @param access_token
	 * @return
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws Exception
	 */
	public static String deleteMenu(String access_token) throws IOException, 
		KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		JSONObject jsonObject = null;
		StringBuffer sb = new StringBuffer(Constants.WX_MENU_DELETE);
		sb.append("?access_token=").append(access_token);
		String url = sb.toString();
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(url, "");
//		System.out.println(jsonObject.toString());
		@SuppressWarnings("static-access")
		WxMenuButtonCreateResult button = jsonObject.toJavaObject(jsonObject, WxMenuButtonCreateResult.class);
		return button.getErrmsg();
	}
	
	/**
	 * <p>getMenu</p>
	 * <p>自定义菜单 查看菜单</p>
	 * @author damon
	 * @date 2015年3月20日
	 * @param access_token
	 * @return
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String getMenu(String access_token) throws IOException, 
		KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException{
		JSONObject jsonObject = null;
		StringBuffer sb = new StringBuffer(Constants.WX_MENU_GET);
		sb.append("?access_token=").append(access_token);
		String url = sb.toString();
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(url, "");
//		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						帐号管理接口
  	//-- ---------------------------------------------------------------- --//
    /**
     * <p>createQrcode</p>
     * <p>创建二维码</p>
     * @author damon
     * @date 2015年5月26日
     * @param access_token
     * @param params
     * @return
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws IOException
     */
    public static String createQrcodeAndGetTicket(String access_token, String params) throws KeyManagementException, 
    	NoSuchAlgorithmException, NoSuchProviderException, IOException {
    	JSONObject jsonObject = null;
		StringBuffer sb = new StringBuffer(Constants.WX_QRCODE_CREATE);
		sb.append("?access_token=").append(access_token);
		String url = sb.toString();
		jsonObject = JavaRequestAndResponse.doPostHttpsURLRequestDefaultHeaderReturnJson(url, params);
//		System.out.println(jsonObject.toString());
		@SuppressWarnings("static-access")
		QrcodeRS qrcode = jsonObject.toJavaObject(jsonObject, QrcodeRS.class);
		return qrcode.getTicket();
    }
    
    /**
     * <p>getQrcode</p>
     * <p>换取二维码图片</p>
     * @author damon
     * @date 2015年5月26日
     * @param ticket UrlEncode 处理过的ticket
     * @param pathName
     * @return
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws IOException
     */
    public static String getQrcode(String ticket, String pathName) 
    		throws KeyManagementException, NoSuchAlgorithmException, 
    		NoSuchProviderException, IOException {
    	Map<String, String> requestHeaderMap_ = new HashMap<String, String>();
		requestHeaderMap_.put("Accept-Language", "zh-cn,zh;q=0.5");
    	StringBuffer sb = new StringBuffer(Constants.WX_SHOWQRCODE);
		sb.append("?ticket=").append(ticket);
		String urlStr = sb.toString();
		pathName = JavaRequestAndResponse.downloadFileByHttpUrl(urlStr, pathName, requestHeaderMap_);
//		System.out.println(pathName);
    	return pathName;
    }
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						数据统计接口
  	//-- ---------------------------------------------------------------- --//
    
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						微信JS-SDK接口
  	//-- ---------------------------------------------------------------- --//
    /**
	 * <p>getTicket</p>
	 * <p>获取微信 jsapi_ticket </p>
	 * @author damon
	 * @date 2015年1月19日
	 * @param access_token
	 * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
	 */
	public static String getTicket(String access_token) throws IOException, 
		KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		JSONObject jsonObject = null;
		// 获取微信 jsapi_ticket 
		StringBuffer sb = new StringBuffer(Constants.WX_TICKET_GETTICKET);
		sb.append("?type=").append(Constants.GRANT_TYPE_JSAPI);
		sb.append("&access_token=").append(access_token);
		String url = sb.toString();
		jsonObject = JavaRequestAndResponse.doGetHttpsURLRequestDefaultHeaderReturnJson(url, "");
//		System.out.println(jsonObject.toString());
		@SuppressWarnings("static-access")
		JsTicket ticket = jsonObject.toJavaObject(jsonObject, JsTicket.class);
		return ticket.getTicket();
	}
	
	/**
	 * <p>getJsApiTicket</p>
	 * <p>JS-SDK权限验证的签名</p>
	 * @author damon
	 * @date 2015年1月20日
	 * @param jsapi_ticket
	 * @param url
	 * @return
	 */
	public static JSONObject getJsApiTicket(String jsapi_ticket, String url) {
		JSONObject jsonObject = null;
		Map<String, Object> ret = sign(jsapi_ticket, url);
		jsonObject = new JSONObject(ret);
		return jsonObject;
	}
	
	/**
	 * <p>sign</p>
	 * <p>签名生成算法</p>
	 * @author damon
	 * @date 2015年1月19日
	 * @param jsapi_ticket
	 * @param url
	 * @return
	 */
	public static Map<String, Object> sign(String jsapi_ticket, String url) {
        Map<String, Object> ret = new HashMap<String, Object>();
//        String nonce_str = "82693e11-b9bc-448e-892f-f5289f46cd0f";
//        String timestamp = "1419835025";
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        // 注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
//        System.out.println(string1);
        try{
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
    }

    /**
     * <p>byteToHex</p>
     * <p>byteToHex</p>
     * @author damon
     * @date 2015年1月19日
     * @param hash
     * @return
     */
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * <p>create_nonce_str</p>
     * <p>nonce_str</p>
     * @author damon
     * @date 2015年1月19日
     * @return
     */
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    /**
     * <p>create_timestamp</p>
     * <p>创建微信时间戳</p>
     * @author damon
     * @date 2015年1月19日
     * @return
     */
    public static String create_timestamp() {
        return Long.toString(createTimestamp());
    }
    
    /**
     * <p>createTimestamp</p>
     * <p>创建微信时间戳</p>
     * @author damon
     * @date 2015年1月23日
     * @return
     */
    public static Long createTimestamp() {
    	return System.currentTimeMillis() / 1000;
    }
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						微信智能接口
  	//-- ---------------------------------------------------------------- --//
    
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						多客服功能接口
  	//-- ---------------------------------------------------------------- --//
    
    
    //-- ---------------------------------------------------------------- --//
  	//-- 						消息处理功能
  	//-- ---------------------------------------------------------------- --//
	/**
	 * <p>ReceivedMsg</p>
	 * <p>接收微信端发送过来的数据</p>
	 * @author damon
	 * @date 2014年12月19日
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String ReceivedMsg(InputStream is) throws IOException {
		// 读取接收到的消息
		StringBuffer sb = new StringBuffer();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		String result = sb.toString();
//		System.out.println("ReceivedMsg:" + result);
		return result;
	}
	
	/**
	 * <p>decryptMsg</p>
	 * <p>解密微信密文消息</p>
	 * @author damon
	 * @date 2015年3月27日
	 * @param token
	 * @param encodingaeskey
	 * @param appid
	 * @param ciphertext
	 * @param msgSignature
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws AesException
	 */
	public static String decryptMsg(String token, String encodingaeskey, String appid, 
			String ciphertext, String msgSignature, String timestamp, String nonce) 
			throws ParserConfigurationException, SAXException, IOException, AesException {
		String plaintext = "";
		// 取密文对象
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingaeskey, appid);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(ciphertext);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);
		Element root = document.getDocumentElement();
		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
		String encrypt = nodelist1.item(0).getTextContent();

		// 格式化
		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
		String fromXML = String.format(format, encrypt);

		// 解密
		plaintext = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		System.out.println("解密后明文: " + plaintext);
		return plaintext;
	}

	/**
	 * <p>decryptMsg</p>
	 * <p>解密微信密文消息   默认账号</p>
	 * @author damon
	 * @date 2015年3月27日
	 * @param ciphertext
	 * @param timestamp
	 * @param nonce
	 * @param msgSignature
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws AesException
	 */
	public static String decryptMsg(String ciphertext, String msgSignature, String timestamp, 
			String nonce) throws ParserConfigurationException, 
			SAXException, IOException, AesException {
		return decryptMsg(Constants.TOKEN, Constants.ENCODINGAESKEY, Constants.APPID, 
				ciphertext, msgSignature, timestamp, nonce);
	}
	
	/**
	 * <p>encryptMsg</p>
	 * <p>加密微信明文消息</p>
	 * @author damon
	 * @date 2015年3月19日
	 * @param token
	 * @param encodingaeskey
	 * @param appid
	 * @param plaintext
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws AesException
	 */
	public static String encryptMsg(String token, String encodingaeskey, String appid, 
			String plaintext, String timestamp, String nonce) throws AesException {
		String ciphertext = "";
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingaeskey, appid);
		ciphertext = pc.encryptMsg(plaintext, timestamp, nonce);
		System.out.println("加密后密文: " + ciphertext);
		return ciphertext;
	}

	/**
	 * <p>encryptMsg</p>
	 * <p>加密微信明文消息</p>
	 * @author damon
	 * @date 2014年12月22日
	 * @param plaintext
	 * @param timestamp
	 * @param nonce
	 * @return 密文
	 * @throws AesException
	 */
	public static String encryptMsg(String plaintext, String timestamp,
			String nonce) throws AesException {
		return encryptMsg(Constants.TOKEN, Constants.ENCODINGAESKEY, Constants.APPID, 
				plaintext, timestamp, nonce);
	}
	
	/**
	 * <p>encryptMsg</p>
	 * <p>加密微信明文消息</p>
	 * @author damon
	 * @date 2014年12月22日
	 * @param plaintext
	 * @return 密文
	 * @throws AesException
	 */
	public static String encryptMsg(String plaintext) throws AesException {
		String timestamp = createTimestamp().toString();
		String nonce = create_nonce_str();
		return encryptMsg(Constants.TOKEN, Constants.ENCODINGAESKEY, Constants.APPID, 
				plaintext, timestamp, nonce);
	}

	/**
	 * <p>subParams</p>
	 * <p>URL中取参数</p>
	 * @author damon
	 * @date 2014年12月23日
	 * @param url
	 * @return
	 */
	public static Map<String, String> subParams(String url) {
		Map<String, String> map = new HashMap<String, String>();
		int p_1 = url.indexOf("?");
		int p_2 = url.indexOf("#");
		String param = url.substring(p_1 + 1, p_2);
//		System.out.println(param);
		String[] params = param.split("&");
		for(String par : params){
			String[] pp = par.split("=");
			map.put(pp[0], pp[1]);
		}
		return map;
	}
	
	
//	private static int errCode;
//    private static String loginErrMsg = "";
//	/**
//     * 发送登录信息,记录cookie，登录状态，token等信息
//     *
//     * @return
//     */
//    public static boolean _login() {
//        try {
//                switch(errCode) {
//                    case -1:
//                        loginErrMsg = "系统错误";
//                        return false;
//                    case -2:
//                        loginErrMsg = "帐号或密码错误";
//                        return false;
//                    case -3:
//                        loginErrMsg = "密码错误";
//                        return false;
//                    case -4:
//                        loginErrMsg = "不存在该帐户";
//                        return false;
//                    case -5:
//                        loginErrMsg = "访问受限";
//                        return false;
//                    case -6:
//                        loginErrMsg = "需要输入验证码";
//                        return false;
//                    case -7:
//                        loginErrMsg = "此帐号已绑定私人微信号，不可用于公众平台登录";
//                        return false;
//                    case -8:
//                        loginErrMsg = "邮箱已存在";
//                        return false;
//                    case -32:
//                        loginErrMsg = "验证码输入错误";
//                        return false;
//                    case -200:
//                        loginErrMsg = "因频繁提交虚假资料，该帐号被拒绝登录";
//                        return false;
//                    case -94:
//                        loginErrMsg = "请使用邮箱登陆";
//                        return false;
//                    case 10:
//                        loginErrMsg = "该公众会议号已经过期，无法再登录使用";
//                        return false;
//                    case 65201:
//                    case 65202:
//                        loginErrMsg = "成功登陆，正在跳转...";
//                        return true;
//                    case 0:
//                        loginErrMsg = "成功登陆，正在跳转...";
//                        return true;
//                    default:
//                        loginErrMsg = "未知的返回";
//                        return false;
//                }
//        } catch (Exception e) {
//            String info = "【登录失败】【发生异常：" + e.getMessage() + "】";
//            System.err.println(info);
//            return false;
//        }
//    }
	
}
