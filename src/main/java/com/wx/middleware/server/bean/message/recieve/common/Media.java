/**
 * <p>Title: Media.java</p>
 * <p>消息媒体</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.common;

/**
 * <p>Title: Media</p>
 * <p>消息媒体</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class Media extends Common {

	/**
	 * MediaId 消息媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	private String MediaId;

	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return MediaId;
	}

	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
