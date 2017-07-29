/**
 * <p>Title: NewsItemContentItem.java</p>
 * <p></p>
 * @author damon
 * @date 2015年3月20日
 * @version 1.0
 */
package com.wx.middleware.server.bean.material;

/**
 * <p>Title: NewsItemContentItem</p>
 * <p></p> 
 * @author damon
 * @date 2015年3月20日
 */
public class NewsItemContentItem {

	private String content;						// 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS 

	private String author;						// 作者 
	
	private String title;						// 图文消息的标题 
	
	private String thumb_media_id;				// 图文消息的封面图片素材id（必须是永久mediaID）
	
	private String show_cover_pic;				// 是否显示封面，0为false，即不显示，1为true，即显示 
	
	private String content_source_url;			// 图文消息的原文地址，即点击“阅读原文”后的URL
	
	private String digest;						// 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	
	private String image_localurl;					// 本地图片地址
	
	/* ********** ********** getter and setter ********** ********** */
	
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the thumb_media_id
	 */
	public String getThumb_media_id() {
		return thumb_media_id;
	}

	/**
	 * @param thumb_media_id the thumb_media_id to set
	 */
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	/**
	 * @return the show_cover_pic
	 */
	public String getShow_cover_pic() {
		return show_cover_pic;
	}

	/**
	 * @param show_cover_pic the show_cover_pic to set
	 */
	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	/**
	 * @return the content_source_url
	 */
	public String getContent_source_url() {
		return content_source_url;
	}

	/**
	 * @param content_source_url the content_source_url to set
	 */
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}

	/**
	 * @return the digest
	 */
	public String getDigest() {
		return digest;
	}

	/**
	 * @param digest the digest to set
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}
	
}
