/**
 * <p>Title: NewsMessage.java</p>
 * <p>图文消息</p>
 * <p>单图文 多图文(微信定义最多1~10条)</p> 
 * @author damon
 * @date 2015年3月16日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.send;

import java.util.List;

import com.wx.middleware.server.bean.message.BaseMessage;

/**
 * <p>Title: NewsMessage</p>
 * <p>图文消息</p>
 * <p>单图文 多图文(微信定义最多1~10条)</p> 
 * @author damon
 * @date 2015年3月16日
 */
public class NewsMessage extends BaseMessage {
	
	/**
	 * WX_XML_ARTICLECOUNT_B 图文消息个数开始标签
	 */
	private static final String WX_XML_ARTICLECOUNT_B = "<ArticleCount>";
	
	/**
	 * WX_XML_ARTICLECOUNT_E 图文消息个数结束标签
	 */
	private static final String WX_XML_ARTICLECOUNT_E = "</ArticleCount>";
	
	/**
	 * WX_XML_ARTICLES_B 多条图文消息信息开始标签
	 */
	private static final String WX_XML_ARTICLES_B = "<Articles>";
	
	/**
	 * WX_XML_ARTICLES_E 多条图文消息信息结束标签
	 */
	private static final String WX_XML_ARTICLES_E = "</Articles>";
	
	/**
	 * WX_XML_ITEM_B item项开始标签
	 */
	private static final String WX_XML_ITEM_B = "<item>";
	
	/**
	 * WX_XML_ITEM_E item项结束标签
	 */
	private static final String WX_XML_ITEM_E = "</item>";
	
	/**
	 * WX_XML_TITLE_B 图文消息标题开始标签
	 */
	private static final String WX_XML_TITLE_B = "<Title><![CDATA[";
	
	/**
	 * WX_XML_TITLE_E 图文消息标题结束标签
	 */
	private static final String WX_XML_TITLE_E = "]]></Title>";
	
	/**
	 * WX_XML_DESCRIPTION_B 图文消息描述开始标签
	 */
	private static final String WX_XML_DESCRIPTION_B = "<Description><![CDATA[";
	
	/**
	 * WX_XML_DESCRIPTION_E 图文消息描述结束标签
	 */
	private static final String WX_XML_DESCRIPTION_E = "]]></Description>";
	
	/**
	 * WX_XML_PICURL_B 图片链接开始标签
	 */
	private static final String WX_XML_PICURL_B = "<PicUrl><![CDATA[";
	
	/**
	 * WX_XML_PICURL_E 图片链接结束标签
	 */
	private static final String WX_XML_PICURL_E = "]]></PicUrl>";
	
	/**
	 * WX_XML_URL_B 点击图文消息跳转链接开始标签
	 */
	private static final String WX_XML_URL_B = "<Url><![CDATA[";
	
	/**
	 * WX_XML_URL_E 点击图文消息跳转链接结束标签
	 */
	private static final String WX_XML_URL_E = "]]></Url>";

	/**
	 * ArticleCount 图文消息个数，限制为10条以内
	 */
	private int ArticleCount;
	
	private List<News> items;
	
	public NewsMessage(List<News> items) {
		this.items = items;
	}
	
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
    	sb.append(WX_XML_ARTICLECOUNT_B);
    	sb.append(items.size());
    	sb.append(WX_XML_ARTICLECOUNT_E);
    	sb.append(WX_XML_ARTICLES_B);
    	for(News news : items){
    		sb.append(WX_XML_ITEM_B);
    		sb.append(WX_XML_TITLE_B);
        	sb.append(news.getTitle());
        	sb.append(WX_XML_TITLE_E);
        	sb.append(WX_XML_DESCRIPTION_B);
        	sb.append(news.getDescription());
        	sb.append(WX_XML_DESCRIPTION_E);
        	sb.append(WX_XML_PICURL_B);
        	sb.append(news.getPicUrl());
        	sb.append(WX_XML_PICURL_E);
        	sb.append(WX_XML_URL_B);
        	sb.append(news.getUrl());
        	sb.append(WX_XML_URL_E);
        	sb.append(WX_XML_ITEM_E);
    	}
    	sb.append(WX_XML_ARTICLES_E);
    	return sb;
    }
	
//	public static void main(String[] args) {
//		List<News> items = new ArrayList<News>();
//		News news0 = new News();
//		news0.setTitle("title0");
//		news0.setDescription("desc0");
//		news0.setPicUrl("");
//		news0.setUrl("");
//		items.add(news0);
//		News news1 = new News();
//		news1.setTitle("title1");
//		news1.setDescription("desc1");
//		news1.setPicUrl("");
//		news1.setUrl("");
//		items.add(news1);
//		NewsMessage nm = new NewsMessage(items);
//		nm.setToUserName("wx59b9035ec663ded4");
//		nm.setFromUserName("wxdea97090fe1dcd9c");
//		nm.setCreateTime(System.currentTimeMillis() / 1000);
//		nm.setMsgType("news");
//		System.out.println(nm.toString());
//	}
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the articleCount
	 */
	public int getArticleCount() {
		return ArticleCount;
	}

	/**
	 * @param articleCount the articleCount to set
	 */
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	
}
