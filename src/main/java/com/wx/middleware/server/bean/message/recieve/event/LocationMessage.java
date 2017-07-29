/**
 * <p>Title: LocationMessage.java</p>
 * <p>上报地理位置事件</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.event;

/**
 * <p>Title: LocationMessage</p>
 * <p>上报地理位置事件</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class LocationMessage extends Event {

	/**
	 * Latitude 地理位置纬度
	 */
	private String Latitude;
	
    /**
     * Longitude 地理位置经度
     */
    private String Longitude; 
    
    /**
     * Precision 地理位置精度
     */
    private String Precision; 
    
    /* ********** ********** getter and setter ********** ********** */
    
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
}
