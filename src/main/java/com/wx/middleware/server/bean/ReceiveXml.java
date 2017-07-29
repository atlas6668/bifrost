/**
 * <p>Title: ReceiveXml.java</p>
 * <p>接收到的微信xml</p>
 * @author damon
 * @date 2014年12月19日
 * @version 1.0
 */
package com.wx.middleware.server.bean;

/**
 * <p>Title: ReceiveXml</p>
 * <p>接收到的微信xml</p> 
 * @author damon
 * @date 2014年12月19日
 */
public class ReceiveXml {

	//-- ---------------------------------------------------------------- --//
	//-- 各类消息公共属性
	//-- ---------------------------------------------------------------- --//
	/**
	 * ToUserName 开发者微信号 
	 */
	private String ToUserName="";  
    /**
     * FromUserName 发送方帐号（一个OpenID） 
     */
    private String FromUserName="";  
    /**
     * CreateTime 消息创建时间 （整型）
     */
    private String CreateTime="";  
    /**
     * MsgType (text image voice video location link)
     */
    private String MsgType="";  
    /**
     * MsgId 文本消息内容 
     */
    private String MsgId="";  
    
    //-- ---------------------------------------------------------------- --//
  	//-- 文本消息属性
  	//-- ---------------------------------------------------------------- --//
    private String Content="";  
    
    //-- ---------------------------------------------------------------- --//
  	//-- 图片消息、语音消息、视频消息公共属性
  	//-- ---------------------------------------------------------------- --//
    private String MediaId=""; 
    
    //-- ---------------------------------------------------------------- --//
  	//-- 图片消息属性
  	//-- ---------------------------------------------------------------- --//
    private String PicUrl="";
    
    //-- ---------------------------------------------------------------- --//
  	//-- 语音消息属性
  	//-- ---------------------------------------------------------------- --//
    private String Format=""; 
    
    //-- ---------------------------------------------------------------- --//
  	//-- 视频消息属性
  	//-- ---------------------------------------------------------------- --//
    private String ThumbMediaId="";
    
    //-- ---------------------------------------------------------------- --//
  	//-- 地理位置消息属性
  	//-- ---------------------------------------------------------------- --//
    private String Location_X="";  
    private String Location_Y="";  
    private String Scale="";  
    private String Label=""; 
    
    //-- ---------------------------------------------------------------- --//
  	//-- 链接消息属性
  	//-- ---------------------------------------------------------------- --//
    private String Title="";  
    private String Description="";  
    private String Url="";
    
    //-- ---------------------------------------------------------------- --//
  	//-- 事件消息属性
  	//-- ---------------------------------------------------------------- --//
    private String Event="";  
    private String EventKey="";
    private String MenuId="";
    private String Ticket="";  
    
    private String Latitude="";  
    private String Longitude="";  
    private String Precision=""; 
    
    //-- ---------------------------------------------------------------- --//
  	//-- 语音识别消息属性
  	//-- ---------------------------------------------------------------- --//
    private String Recognition="";  
    
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
	public String getCreateTime() {
		return CreateTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
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
	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return MsgId;
	}
	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
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
	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return MediaId;
	}
	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	/**
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return PicUrl;
	}
	/**
	 * @param picUrl the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return Format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		Format = format;
	}
	/**
	 * @return the thumbMediaId
	 */
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	/**
	 * @param thumbMediaId the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	/**
	 * @return the location_X
	 */
	public String getLocation_X() {
		return Location_X;
	}
	/**
	 * @param location_X the location_X to set
	 */
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	/**
	 * @return the location_Y
	 */
	public String getLocation_Y() {
		return Location_Y;
	}
	/**
	 * @param location_Y the location_Y to set
	 */
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	/**
	 * @return the scale
	 */
	public String getScale() {
		return Scale;
	}
	/**
	 * @param scale the scale to set
	 */
	public void setScale(String scale) {
		Scale = scale;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return Label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		Label = label;
	}
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
	public String getMenuId() {
		return MenuId;
	}
	public void setMenuId(String menuId) {
		MenuId = menuId;
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
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return Latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return Longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	/**
	 * @return the precision
	 */
	public String getPrecision() {
		return Precision;
	}
	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(String precision) {
		Precision = precision;
	}
	/**
	 * @return the recognition
	 */
	public String getRecognition() {
		return Recognition;
	}
	/**
	 * @param recognition the recognition to set
	 */
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
