/**
 * <p>Title: LinkMessage.java</p>
 * <p>链接消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.common;

/**
 * <p>Title: LinkMessage</p>
 * <p>链接消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class LinkMessage extends Common {

	/**
	 * Title 消息标题 
	 */
	private String Title; 
	
    /**
     * Description 消息描述
     */
    private String Description; 
    
    /**
     * Url 消息链接
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
