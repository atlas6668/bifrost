/**
 * <p>Title: Event.java</p>
 * <p>事件消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.event;

import com.wx.middleware.server.bean.message.BaseMessage;

/**
 * <p>Title: Event</p>
 * <p>事件消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class Event extends BaseMessage {

	/**
	 * Event 事件类型(subscribe unsubscribe SCAN LOCATION CLICK VIEW)
	 */
	private String Event;

	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the event
	 */
	public String getEvent() {
		return Event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		Event = event;
	} 
}
