/**
 * <p>Title: MaterialOthers.java</p>
 * <p></p>
 * @author damon
 * @date 2015年3月20日
 * @version 1.0
 */
package com.wx.middleware.server.bean.material;

/**
 * <p>Title: MaterialOthers</p>
 * <p></p> 
 * @author damon
 * @date 2015年3月20日
 */
public class MaterialOthers {

	private int item_count;
	
	private int total_count;
	
	private OthersItem[] item;
	
	/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the item_count
	 */
	public int getItem_count() {
		return item_count;
	}

	/**
	 * @param item_count the item_count to set
	 */
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	/**
	 * @return the total_count
	 */
	public int getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count the total_count to set
	 */
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return the item
	 */
	public OthersItem[] getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(OthersItem[] item) {
		this.item = item;
	}
	
}
