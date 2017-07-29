/**
 * <p>Title: OthersItem.java</p>
 * <p></p>
 * @author damon
 * @date 2015年3月20日
 * @version 1.0
 */
package com.wx.middleware.server.bean.material;

/**
 * <p>Title: OthersItem</p>
 * <p></p> 
 * @author damon
 * @date 2015年3月20日
 */
public class OthersItem {

	private Long update_time;					// 这篇图文消息素材的最后更新时间
	
	private String name;						// 文件名称
	
	private String media_id;					// 素材id
	
	private String image_localurl;					// 本地图片地址
	
	private String voice_localurl;					// 本地语音地址
	
	private String vedio_localurl;					// 本地视频地址
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the update_time
	 */
	public Long getUpdate_time() {
		return update_time;
	}

	/**
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the media_id
	 */
	public String getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id the media_id to set
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
	/**
	 * @return the image_localurl
	 */
	public String getImage_localurl() {
		return image_localurl;
	}

	/**
	 * @param image_localurl the image_localurl to set
	 */
	public void setImage_localurl(String image_localurl) {
		this.image_localurl = image_localurl;
	}

	/**
	 * @return the voice_localurl
	 */
	public String getVoice_localurl() {
		return voice_localurl;
	}

	/**
	 * @param voice_localurl the voice_localurl to set
	 */
	public void setVoice_localurl(String voice_localurl) {
		this.voice_localurl = voice_localurl;
	}

	/**
	 * @return the vedio_localurl
	 */
	public String getVedio_localurl() {
		return vedio_localurl;
	}

	/**
	 * @param vedio_localurl the vedio_localurl to set
	 */
	public void setVedio_localurl(String vedio_localurl) {
		this.vedio_localurl = vedio_localurl;
	}
	
}
