/**
 * <p>Title: Qrcode.java</p>
 * <p></p>
 * @author damon
 * @date 2015年5月26日
 * @version 1.0
 */
package com.wx.middleware.server.bean.account;

/**
 * <p>Title: Qrcode</p>
 * <p></p> 
 * @author damon
 * @date 2015年5月26日
 */
public class Qrcode {

}

class QrcodeP {

	private String expire_seconds;
	
	private String action_name;
	
	private String action_info;
	
	private int scene_id;
	
	private String scene_str;
	
	/* ********** ********** getter and setter ********** ********** */
	
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
	 * @return the action_name
	 */
	public String getAction_name() {
		return action_name;
	}

	/**
	 * @param action_name the action_name to set
	 */
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	/**
	 * @return the action_info
	 */
	public String getAction_info() {
		return action_info;
	}

	/**
	 * @param action_info the action_info to set
	 */
	public void setAction_info(String action_info) {
		this.action_info = action_info;
	}

	/**
	 * @return the scene_id
	 */
	public int getScene_id() {
		return scene_id;
	}

	/**
	 * @param scene_id the scene_id to set
	 */
	public void setScene_id(int scene_id) {
		this.scene_id = scene_id;
	}

	/**
	 * @return the scene_str
	 */
	public String getScene_str() {
		return scene_str;
	}

	/**
	 * @param scene_str the scene_str to set
	 */
	public void setScene_str(String scene_str) {
		this.scene_str = scene_str;
	}
	
}

class QrcodeRF {

	private int errcode;
	
	private String errmsg;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the errcode
	 */
	public int getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
