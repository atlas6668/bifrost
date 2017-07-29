/**
 * <p>Title: LocationMessage.java</p>
 * <p>地理位置消息</p>
 * @author damon
 * @date 2015年1月22日
 * @version 1.0
 */
package com.wx.middleware.server.bean.message.recieve.common;

/**
 * <p>Title: LocationMessage</p>
 * <p>地理位置消息</p> 
 * @author damon
 * @date 2015年1月22日
 */
public class LocationMessage extends Common {

	/**
	 * Location_X 地理位置维度
	 */
	private String Location_X; 
	
    /**
     * Location_Y 地理位置经度
     */
    private String Location_Y; 
    
    /**
     * Scale 地图缩放大小 
     */
    private String Scale;  
    
    /**
     * Label 地理位置信息 
     */
    private String Label; 
    
	
	/* ********** ********** getter and setter ********** ********** */
    
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
}
