/**
 * <p>Title: AccessToken.java</p>
 * <p>微信公众平台AccessToken</p>
 * @author damon
 * @date 2014年12月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.base;

/**
 * <p>Title: AccessToken</p>
 * <p>微信公众平台AccessToken</p>
 * @author damon
 * @date 2014年12月22日
 */
public class AccessToken {
	// 获取到的凭证
	private String access_token;

	// 凭证有效时间，单位：秒
	private int expires_in;
	
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
	public int getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
}
