/**
 * <p>Title: WxMenuButton.java</p>
 * <p></p>
 * @author damon
 * @date 2015年4月8日
 * @version 1.0
 */
package com.wx.middleware.server.bean.menu;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.wx.middleware.server.util.WeiXinUtil;

/**
 * <p>Title: WxMenuButton</p>
 * <p></p> 
 * @author damon
 * @date 2015年4月8日
 */
public class WxMenuButton {

	private String type;
	
	private String name;
	
	private String key;
	
	private String url;
	
	private boolean isOauth2Url = true;
	
	private String appid;
	
	private List<WxMenuButton> sub_buttons;
	
	public WxMenuButton(String type, String name, String key, String url, 
			boolean isOauth2Url, String appid, List<WxMenuButton> sub_buttons) {
		this.type = type;
		this.name = name;
		this.key = key;
		this.url = url;
		this.isOauth2Url = isOauth2Url;
		this.appid = appid;
		this.sub_buttons = sub_buttons;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		// 无子菜单
		if(sub_buttons == null){
			sb.append("\"type\":\"").append(type).append("\",");
			sb.append("\"name\":\"").append(name).append("\",");
			if(type.equals("view")){
				if(isOauth2Url){
					try {
						String encodeurl = java.net.URLEncoder.encode(url, "UTF-8");
						String oauth2url = WeiXinUtil.decorateOauth2Url(appid, encodeurl);
						sb.append("\"url\":\"").append(oauth2url).append("\"");
					} catch (UnsupportedEncodingException e) {
						System.out.println(e.getMessage());
					}
				} else {
					sb.append("\"url\":\"").append(url).append("\"");
				}
			} else if(type.equals("click")){
				sb.append("\"key\":\"").append(key).append("\"");
			}
		} else {
			sb.append("\"name\":\"").append(name).append("\",");
			sb.append("\"sub_button\":[");
			for(int i = 0; i < sub_buttons.size(); i++){
				sb.append(sub_buttons.get(i).toString());
				if(i < sub_buttons.size() - 1){
					sb.append(",");
				}
			}
			sb.append("]");
		}
		sb.append("}");
		return sb.toString();
	}
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the sub_buttons
	 */
	public List<WxMenuButton> getSub_buttons() {
		return sub_buttons;
	}

	/**
	 * @param sub_buttons the sub_buttons to set
	 */
	public void setSub_buttons(List<WxMenuButton> sub_buttons) {
		this.sub_buttons = sub_buttons;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the isOauth2Url
	 */
	public boolean isOauth2Url() {
		return isOauth2Url;
	}

	/**
	 * @param isOauth2Url the isOauth2Url to set
	 */
	public void setOauth2Url(boolean isOauth2Url) {
		this.isOauth2Url = isOauth2Url;
	}
	
	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	
}
