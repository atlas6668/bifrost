/**
 * <p>Title: Oauth2.java</p>
 * <p>微信平台Oauth2用户认证获取的用户信息</p>
 * @author damon
 * @date 2014年12月23日
 * @version 1.0
 */
package com.wx.middleware.server.bean.user;

/**
 * <p>Title: Oauth2</p>
 * <p>微信平台Oauth2用户认证获取的用户信息</p> 
 * @author damon
 * @date 2014年12月23日
 */
public class Oauth2 {

	private String access_token;
	
	private String expires_in;
	
	private String refresh_token;
	
	private String openid;
	
	private String scope;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return the expires_in
	 */
	public String getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @return the refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}

	/**
	 * @param refresh_token the refresh_token to set
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
}
