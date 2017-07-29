/**
 * <p>Title: News.java</p>
 * <p>图文消息消息</p>
 * @author damon
 * @date 2015年3月16日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.send;

/**
 * <p>Title: News</p>
 * <p>图文消息</p> 
 * @author damon
 * @date 2015年3月16日
 */
public class News {

	/**
	 * Title 图文消息标题
	 */
	private String Title;
	
	/**
	 * Description 图文消息描述
	 */
	private String Description;
	
	/**
	 * PicUrl 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	private String PicUrl;
	
	/**
	 * Url 点击图文消息跳转链接
	 */
	private String Url;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

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

	/**
	 * @return the url
	 */
	public String getUrl() {
		return Url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		Url = url;
	}
	
}
