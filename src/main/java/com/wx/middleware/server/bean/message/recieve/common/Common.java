/**
 * <p>Title: Base.java</p>
 * <p>普通消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.common;

import com.wx.middleware.server.bean.message.BaseMessage;

/**
 * <p>Title: Base</p>
 * <p>普通消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class Common extends BaseMessage {
	
	/**
	 * WX_XML_MSGID_B 
	 */
	public static final String WX_XML_MSGID_B = "<MsgId>";
	
	/**
	 * WX_XML_MSGID_E 
	 */
	public static final String WX_XML_MSGID_E = "</MsgId>";

	/**
     * MsgId 消息id，64位整型 
     */
    private Long MsgId;
    
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
//    	// 拓展自己属性
//    	sb = buildXML(sb);
    	// 结束XML
		sb = super.endXML(sb);
		return sb.toString();
    }
    
//    /* (non-Javadoc)
//     * <p>buildXML</p>
//     * <p>填充XML</p>
//     * @param sbf
//     * @return
//     * @see com.xiaoma.rob.weixin.bean.message.BaseMessage#buildXML(java.lang.StringBuffer)
//     */
//    protected StringBuffer buildXML(StringBuffer sbf) {
//    	StringBuffer sb = sbf;
//    	
//    	return sb;
//    }
    
//    public static void main(String[] args) {
//    	System.out.println(new Common().toString());
//    }
    
    /* ********** ********** getter and setter ********** ********** */
    
    /**
	 * @return the msgId
	 */
	public Long getMsgId() {
		return MsgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}
}
