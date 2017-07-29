package com.wx.middleware.server.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.qq.weixin.mp.aes.AesException;

public class T {

	public static void main(String[] args) {
		String xmlStr = "<xml>    <ToUserName><![CDATA[gh_d74c1c8ca282]]></ToUserName>    <Encrypt><![CDATA[8l6Y204EI+wnJT7ZPUcfWwaRh+XSjvSVnV2xn33JUo0e++Hvukx0ORVpgLUY8bzCnLL1DTIGKdVX1n3UEnh8NQBRucaQql0lMm2xVfHdhLnTmOhjhAJeKbkJiCrx9QLA2p6LFgk6UsaiAKXU3cg6gNTvKBxw+Le7qhzemE8W+aP0OoyCeNMn+TRKDSUuVAtyX8VGFLy2muGhs3cWIP055pPq7ZXLw//d4tFvWsj5Imhs9b41mlx+GiLicDQg/yqc+ZXI65MyJ4ZvhwyAWRTUmLZYI5gOBPMPNJJvYAwaR/QO6IXChXaR/+UpRfSQE3q/geOS9XmoRrC6iE6ht5Zw5qYdshqwnGoW67sUoEH8ypSJcThMbYCQ/YaYtC7MRFdBkVz3a2bSq7HY4muwcHpmHMx77TNZxeksJl0hsI1x5mg=]]></Encrypt></xml>";
		String msgSignature = "52041d1d27a0af0a8f9a36103a05b7621898da99";
		String timestamp = "1459138316";
		String nonce = "1399559202";
		try {
			xmlStr = WeiXinUtil.decryptMsg(xmlStr, msgSignature, timestamp, nonce);
			System.out.println(xmlStr);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AesException e) {
			e.printStackTrace();
		}
	}

}
