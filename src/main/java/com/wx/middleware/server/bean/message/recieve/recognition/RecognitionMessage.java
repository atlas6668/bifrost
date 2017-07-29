/**
 * <p>Title: RecognitionMessage.java</p>
 * <p>语音识别消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.recognition;

import com.wx.middleware.server.bean.message.BaseMessage;

/**
 * <p>Title: RecognitionMessage</p>
 * <p>语音识别消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class RecognitionMessage extends BaseMessage {

	private String MediaId;
	
	private String Format;
	
	private String Recognition;
	
	private Long MsgId;
	
	/* ********** ********** getter and setter ********** ********** */
	
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
