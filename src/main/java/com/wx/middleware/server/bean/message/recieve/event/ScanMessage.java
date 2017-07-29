/**
 * <p>Title: ScanMessage.java</p>
 * <p>扫描带参数二维码事件</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.event;

/**
 * <p>Title: ScanMessage</p>
 * <p>扫描带参数二维码事件</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class ScanMessage extends Event {

	/**
	 * EventKey 
	 * 用户未关注时（事件KEY值，qrscene_为前缀，后面为二维码的参数值）
	 * 用户已关注时（事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id ）
	 */
	private String EventKey; 
	
    /**
     * Ticket 二维码的ticket，可用来换取二维码图片
     */
    private String Ticket;
    
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

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return Ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
