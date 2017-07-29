/**
 * <p>Title: NewsItemContent.java</p>
 * <p></p>
 * @author damon
 * @date 2015年3月20日
 * @version 1.0
 */
package com.wx.middleware.server.bean.material;

/**
 * <p>Title: NewsItemContent</p>
 * <p></p> 
 * @author damon
 * @date 2015年3月20日
 */
public class NewsItemContent {

	private NewsItemContentItem[] news_item;

	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the news_item
	 */
	public NewsItemContentItem[] getNews_item() {
		return news_item;
	}

	/**
	 * @param news_item the news_item to set
	 */
	public void setNews_item(NewsItemContentItem[] news_item) {
		this.news_item = news_item;
	}
	
}
