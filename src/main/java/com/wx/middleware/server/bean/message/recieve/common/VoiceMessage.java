/**
 * <p>Title: VoiceMessage.java</p>
 * <p>语音消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.common;

/**
 * <p>Title: VoiceMessage</p>
 * <p>语音消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class VoiceMessage extends Media {

	/**
	 * Format 语音格式，如amr，speex等 
	 */
	private String Format;

	/* ********** ********** getter and setter ********** ********** */
	
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
}
