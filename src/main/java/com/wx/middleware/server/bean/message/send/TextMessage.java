/**
 * <p>Title: TextMessage.java</p>
 * <p>文本消息</p>
 * @author damon
 * @date 2015年3月16日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.send;

import com.wx.middleware.server.bean.message.BaseMessage;

/**
 * <p>Title: TextMessage</p>
 * <p>文本消息</p> 
 * @author damon
 * @date 2015年3月16日
 */
public class TextMessage extends BaseMessage {

	/**
	 * WX_XML_CONTENT_B 文本消息内容开始标签
	 */
	private static final String WX_XML_CONTENT_B = "<Content><![CDATA[";
	
	/**
	 * WX_XML_CONTENT_E 文本消息内容结束标签
	 */
	private static final String WX_XML_CONTENT_E = "]]></Content>";

	/**
	 * Content 文本消息内容 
	 */
	private String Content;
	
	/* (non-Javadoc)
     * <p>toString</p>
     * <p>构造XML</p>
     * @return
     * @see com.xiaoma.rob.weixin.bean.message.BaseMessage#toString()
     */
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	// 开始XML
    	sb = super.beginXML(sb);
    	// 拼装基类属性
    	sb = super.buildXML(sb);
    	// 拓展自己属性
    	sb = buildXML(sb);
    	// 结束XML
		sb = super.endXML(sb);
		return sb.toString();
    }
	
	/* (non-Javadoc)
	 * <p>buildXML</p>
	 * <p>填充XML</p>
	 * @param sbf
	 * @return
	 * @see com.xiaoma.rob.weixin.bean.message.BaseMessage#buildXML(java.lang.StringBuffer)
	 */
	protected StringBuffer buildXML(StringBuffer sbf) {
    	StringBuffer sb = sbf;
    	sb.append(WX_XML_CONTENT_B);
    	sb.append(this.Content);
    	sb.append(WX_XML_CONTENT_E);
    	return sb;
    }
	
	public static void main(String[] args) {
		TextMessage tm = new TextMessage();
		tm.setToUserName("wx59b9035ec663ded4");
		tm.setFromUserName("wxdea97090fe1dcd9c");
		tm.setCreateTime(System.currentTimeMillis() / 1000);
		tm.setMsgType("text");
		tm.setContent("welcome.");
    	System.out.println(tm.toString());
    }
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		Content = content;
	}
	
}
