/**
 * <p>Title: WxMenuButtonCreateResult.java</p>
 * <p>微信自定义Button推送结果</p>
 * @author damon
 * @date 2014年12月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.menu;

/**
 * <p>Title: WxMenuButtonCreateResult</p>
 * <p>微信自定义Button推送结果</p> 
 * @author damon
 * @date 2014年12月22日
 */
public class WxMenuButtonCreateResult {

	//错误信息
	private String errmsg;
	
	//错误代码
	private String errcode;
	
	/* ********** ********** getter and setter ********** ********** */
	
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

	/**
	 * @return the errcode
	 */
	public String getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
}
