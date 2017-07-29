/**
 * <p>Title: VideoMessage.java</p>
 * <p>视频消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.common;

/**
 * <p>Title: VideoMessage</p>
 * <p>视频消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class VideoMessage extends Media {

	/**
	 * ThumbMediaId 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	private String ThumbMediaId;

	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the thumbMediaId
	 */
	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	/**
	 * @param thumbMediaId the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
