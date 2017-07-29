/**
 * <p>Title: MaterialCount.java</p>
 * <p>微信素材总数</p>
 * @author damon
 * @date 2015年3月19日
 * @version 1.0
 */
package com.wx.middleware.server.bean.material;

/**
 * <p>Title: MaterialCount</p>
 * <p>微信素材总数</p> 
 * @author damon
 * @date 2015年3月19日
 */
public class MaterialCount {
	
	/**
	 * voice_count 
	 */
	private int voice_count;
	
	/**
	 * video_count 
	 */
	private int video_count;
	
	/**
	 * image_count 
	 */
	private int image_count;
	
	/**
	 * news_count 
	 */
	private int news_count;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the voice_count
	 */
	public int getVoice_count() {
		return voice_count;
	}

	/**
	 * @param voice_count the voice_count to set
	 */
	public void setVoice_count(int voice_count) {
		this.voice_count = voice_count;
	}

	/**
	 * @return the video_count
	 */
	public int getVideo_count() {
		return video_count;
	}

	/**
	 * @param video_count the video_count to set
	 */
	public void setVideo_count(int video_count) {
		this.video_count = video_count;
	}

	/**
	 * @return the image_count
	 */
	public int getImage_count() {
		return image_count;
	}

	/**
	 * @param image_count the image_count to set
	 */
	public void setImage_count(int image_count) {
		this.image_count = image_count;
	}

	/**
	 * @return the news_count
	 */
	public int getNews_count() {
		return news_count;
	}

	/**
	 * @param news_count the news_count to set
	 */
	public void setNews_count(int news_count) {
		this.news_count = news_count;
	}
	
}
