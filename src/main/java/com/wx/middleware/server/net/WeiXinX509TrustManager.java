/**
 * <p>Title: WeiXinX509TrustManager.java</p>
 * <p>证书管理器</p>
 * @author damon
 * @date 2014年12月22日
 * @version 1.0
 */
package com.wx.middleware.server.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * <p>Title: WeiXinX509TrustManager</p>
 * <p>证书管理器</p> 
 * @author damon
 * @date 2014年12月22日
 */
public class WeiXinX509TrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub

	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

}
