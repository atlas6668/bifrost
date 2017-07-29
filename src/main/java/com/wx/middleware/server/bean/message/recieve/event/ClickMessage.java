/**
 * <p>Title: ClickMessage.java</p>
 * <p>点击菜单拉取消息时的事件推送</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.event;

/**
 * <p>Title: ClickMessage</p>
 * <p>点击菜单拉取消息时的事件推送</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class ClickMessage extends Event {

	/**
	 * EventKey 点击菜单拉取消息
	 */
	private String EventKey;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the eventKey
	 */
	public String getEventKey() {
		return EventKey;
	}

	/**
	 * @param eventKey the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
