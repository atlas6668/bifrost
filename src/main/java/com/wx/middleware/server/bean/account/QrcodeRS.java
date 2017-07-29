/**
 * <p>Title: QrcodeRS.java</p>
 * <p></p>
 * @author damon
 * @date 2015年5月26日
 * @version 1.0
 */
package com.wx.middleware.server.bean.account;

/**
 * <p>Title: QrcodeRS</p>
 * <p></p> 
 * @author damon
 * @date 2015年5月26日
 */
public class QrcodeRS {

	private String ticket;
	
	private String expire_seconds;
	
	private String url;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the expire_seconds
	 */
	public String getExpire_seconds() {
		return expire_seconds;
	}

	/**
	 * @param expire_seconds the expire_seconds to set
	 */
	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
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
	
}
