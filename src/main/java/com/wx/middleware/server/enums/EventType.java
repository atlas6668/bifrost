/**
 * <p>Title: EventType.java</p>
 * <p>事件类型</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.enums;

/**
 * <p>Title: EventType</p>
 * <p>事件类型</p> 
 * @author damon
 * @date 2015年1月22日
 */
public enum EventType {
	
	SUBSCRIBE, 				// 订阅
	UNSUBSCRIBE, 			// 取消订阅
	SCAN, 					// 扫描
	LOCATION, 				// 上报地理位置
	CLICK, 					// 点击菜单拉取消息
	VIEW 					// 点击菜单跳转链接

}
