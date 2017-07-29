/**
 * <p>Title: NewsItem.java</p>
 * <p></p>
 * @author damon
 * @date 2015年3月20日
 * @version 1.0
 */
package com.wx.middleware.server.bean.material;

/**
 * <p>Title: NewsItem</p>
 * <p></p> 
 * @author damon
 * @date 2015年3月20日
 */
public class NewsItem {

	private NewsItemContent content;
	
	private Long update_time;
	
	private String media_id;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the content
	 */
	public NewsItemContent getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(NewsItemContent content) {
		this.content = content;
	}
	
	/**
	 * @return the update_time
	 */
	public Long getUpdate_time() {
		return update_time;
	}

	/**
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the media_id
	 */
	public String getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id the media_id to set
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
}
