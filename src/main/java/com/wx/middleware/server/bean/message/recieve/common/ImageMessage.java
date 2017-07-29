/**
 * <p>Title: ImageMessage.java</p>
 * <p>图片消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.common;

/**
 * <p>Title: ImageMessage</p>
 * <p>图片消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class ImageMessage extends Media {

	/**
	 * PicUrl 图片链接
	 */
	private String PicUrl;

	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return PicUrl;
	}

	/**
	 * @param picUrl the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
