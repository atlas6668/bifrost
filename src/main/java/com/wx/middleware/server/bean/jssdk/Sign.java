/**
 * <p>Title: Sign.java</p>
 * <p>JS-SDK权限验证的签名</p>
 * @author damon
 * @date 2015年1月19日
 * @version 1.0
 */
package com.wx.middleware.server.bean.jssdk;

/**
 * <p>Title: Sign</p>
 * <p>JS-SDK权限验证的签名</p> 
 * @author damon
 * @date 2015年1月19日
 */
public class Sign {

	private String url;
	
	private String jsapi_ticket;
	
	private String nonceStr;
	
	private String timestamp;
	
	private String signature;
	
	/* ********** ********** getter and setter ********** ********** */
	
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
	 * @return the jsapi_ticket
	 */
	public String getJsapi_ticket() {
		return jsapi_ticket;
	}

	/**
	 * @param jsapi_ticket the jsapi_ticket to set
	 */
	public void setJsapi_ticket(String jsapi_ticket) {
		this.jsapi_ticket = jsapi_ticket;
	}

	/**
	 * @return the nonceStr
	 */
	public String getNonceStr() {
		return nonceStr;
	}

	/**
	 * @param nonceStr the nonceStr to set
	 */
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
