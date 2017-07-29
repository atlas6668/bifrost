/**
 * <p>Title: WxMenu.java</p>
 * <p></p>
 * @author damon
 * @date 2015年4月8日
 * @version 1.0
 */
package com.wx.middleware.server.bean.menu;

import java.util.List;

/**
 * <p>Title: WxMenu</p>
 * <p></p> 
 * @author damon
 * @date 2015年4月8日
 */
public class WxMenu {

	private List<WxMenuButton> buttons;
	
	public WxMenu(List<WxMenuButton> buttons) {
		this.buttons = buttons;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(!buttons.isEmpty()){
			sb.append("{");
			sb.append("\"button\":[");
			
			for(int i = 0; i < buttons.size(); i++){
				sb.append(buttons.get(i).toString());
				if(i < buttons.size() - 1){
					sb.append(",");
				}
			}
			sb.append("]");
			sb.append("}");
		}
		return sb.toString();
	}
	
//	public static void main(String[] args) {
//		WxMenuButton button0 = new WxMenuButton("view","考位订阅",null,"",false,"11111",null);
//		WxMenuButton button10 = new WxMenuButton("view","取消订阅",null,"",false,"",null);
//		WxMenuButton button11 = new WxMenuButton("view","绑定手机",null,"",false,"",null);
//		List<WxMenuButton> sub_buttons = new ArrayList<WxMenuButton>();
//		sub_buttons.add(button10);
//		sub_buttons.add(button11);
//		WxMenuButton button1 = new WxMenuButton("","我的考位",null,null,false,"",sub_buttons);
//		List<WxMenuButton> buttons = new ArrayList<WxMenuButton>();
//		buttons.add(button0);
//		buttons.add(button1);
//		WxMenu menu = new WxMenu(buttons);
//		System.out.println(menu.toString());
//	}
	
}
