/**
 * <p>Title: BaseMessage.java</p>
 * <p>微信消息基类</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message;

/**
 * <p>Title: BaseMessage</p>
 * <p>微信消息基类</p> 
 * @author damon
 * @date 2015年1月22日
 * update
 * @date 2015年1月23日
 */
public class BaseMessage {
	
	/**
	 * WX_XML_XMLB XML开始标签
	 */
	private static final String WX_XML_XML_B = "<xml>";
	
	/**
	 * WX_XML_XMLE XML结束标签
	 */
	private static final String WX_XML_XML_E = "</xml>";
	
	/**
	 * WX_XML_TOUSERNAME_B 接收方帐号开始标签
	 */
	private static final String WX_XML_TOUSERNAME_B = "<ToUserName><![CDATA[";
	
	/**
	 * WX_XML_TOUSERNAME_E 接收方帐号结束标签
	 */
	private static final String WX_XML_TOUSERNAME_E = "]]></ToUserName>";
	
	/**
	 * WX_XML_FROMUSERNAME_B 发送方帐号开始标签
	 */
	private static final String WX_XML_FROMUSERNAME_B = "<FromUserName><![CDATA[";
	
	/**
	 * WX_XML_FROMUSERNAME_E 发送方帐号结束标签
	 */
	private static final String WX_XML_FROMUSERNAME_E = "]]></FromUserName>";
	
	/**
	 * WX_XML_CREATETIME_B 消息创建时间开始标签
	 */
	private static final String WX_XML_CREATETIME_B = "<CreateTime>";
	
	/**
	 * WX_XML_CREATETIME_E 消息创建时间结束标签
	 */
	private static final String WX_XML_CREATETIME_E = "</CreateTime>";
	
	/**
	 * WX_XML_MSGTYPE_B 消息类型开始标签
	 */
	private static final String WX_XML_MSGTYPE_B = "<MsgType><![CDATA[";
	
	/**
	 * WX_XML_MSGTYPE_E 消息类型结束标签
	 */
	private static final String WX_XML_MSGTYPE_E = "]]></MsgType>";

	/**
	 * ToUserName 接收方帐号（一个OpenID）
	 */
	private String ToUserName; 
    /**
     * FromUserName 发送方帐号（一个OpenID） 
     */
    private String FromUserName;
    
    /**
     * CreateTime 消息创建时间 （整型）
     */
    private Long CreateTime; 
    
    /**
     * MsgType 消息类型(text image voice video location link event)
     */
    private String MsgType; 
    
    /* (non-Javadoc)
     * <p>toString</p>
     * <p>构造XML</p>
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb = beginXML(sb);
    	sb = buildXML(sb);
		sb = endXML(sb);
		return sb.toString();
	}
    
    /**
     * <p>beginXML</p>
     * <p>开始XML</p>
     * @author damon
     * @date 2015年1月23日
     */
    protected StringBuffer beginXML(StringBuffer sbf) {
    	StringBuffer sb = sbf;
    	sb.append(WX_XML_XML_B);
    	return sb;
    }

	/**
     * <p>buildXML</p>
     * <p>填充XML</p>
     * @author damon
     * @date 2015年1月23日
     */
    protected StringBuffer buildXML(StringBuffer sbf) {
    	StringBuffer sb = sbf;
    	sb.append(WX_XML_TOUSERNAME_B);
    	sb.append(this.ToUserName);
    	sb.append(WX_XML_TOUSERNAME_E);
    	sb.append(WX_XML_FROMUSERNAME_B);
    	sb.append(this.FromUserName);
    	sb.append(WX_XML_FROMUSERNAME_E);
    	sb.append(WX_XML_CREATETIME_B);
    	sb.append(this.CreateTime);
    	sb.append(WX_XML_CREATETIME_E);
    	sb.append(WX_XML_MSGTYPE_B);
    	sb.append(this.MsgType);
    	sb.append(WX_XML_MSGTYPE_E);
    	return sb;
    }
    
    /**
     * <p>endXML</p>
     * <p>结束XML</p>
     * @author damon
     * @date 2015年1月23日
     */
    protected StringBuffer endXML(StringBuffer sbf) {
    	StringBuffer sb = sbf;
    	sb.append(WX_XML_XML_E);
    	return sb;
    }
    
    public static void main(String[] args) {
    	BaseMessage bm = new BaseMessage();
    	bm.setToUserName("wx59b9035ec663ded4");
    	bm.setFromUserName("wxdea97090fe1dcd9c");
    	bm.setCreateTime(System.currentTimeMillis() / 1000);
    	bm.setMsgType("text");
    	System.out.println(bm.toString());
    }
    
    /* ********** ********** getter and setter ********** ********** */

	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return ToUserName;
	}

	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return FromUserName;
	}

	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	/**
	 * @return the createTime
	 */
	public Long getCreateTime() {
		return CreateTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return MsgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
