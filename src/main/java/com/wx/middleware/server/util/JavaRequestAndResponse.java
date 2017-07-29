/**
 * <p>Title: JavaRequestAndResponse.java</p>
 * <p>Java 请求</p>
 * @author damon
 * @date 2014年12月11日
 * @version 1.0
 */
package com.wx.middleware.server.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.alibaba.fastjson.JSONObject;
import com.wx.middleware.server.net.WeiXinX509TrustManager;

/**
 * <p>Title: JavaRequestAndResponse</p>
 * <p>Java 请求</p> 
 * @author damon
 * @date 2014年12月11日
 */
public class JavaRequestAndResponse {
	
	/* valid HTTP methods */
    public static final String[] METHODS = {
        "GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "TRACE"
    };
    
    // boundary : request头和上传文件内容的分隔符
 	public static final String BOUNDARY = "----------ThIs_Is_tHe_bouNdaRY_$";
    
	
 	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
 	private static URLConnection openUrlConnection(String urlStr, String method, 
			Map<String, String> requestHeaderMap) throws IOException {
		// 创建url对象
		URL url = new URL(urlStr);

		// 打开url连接
		URLConnection connection = url.openConnection();

		// 输出模式,允许把数据向你的Web页传送
		connection.setDoOutput(true);
		// 允许
		connection.setDoInput(true);
		// 连接超时
		connection.setConnectTimeout(60000);
		// 读超时
		connection.setReadTimeout(60000);
		// 用户缓存
		connection.setUseCaches(false);
		connection.setDefaultUseCaches(false);
		// set request header 请求消息头
		if(requestHeaderMap != null) {
			for (Map.Entry<String, String> entry : requestHeaderMap
					.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				if (key != null && val != null) {
					connection.setRequestProperty(key, val);
				}
			}
		}
		return connection;
	}
 	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- HTTPS 请求
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
 	/**
	 * <p>openHttpsUrlConnection</p>
	 * <p>打开HttpsURL连接</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param method
	 * @param requestHeaderMap
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static HttpsURLConnection openHttpsUrlConnection(String urlStr, String method, 
			Map<String, String> requestHeaderMap) throws IOException, NoSuchAlgorithmException, 
			NoSuchProviderException, KeyManagementException {
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new WeiXinX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		// 打开url连接
		HttpsURLConnection connection = (HttpsURLConnection) openUrlConnection(urlStr, method, requestHeaderMap);
		connection.setSSLSocketFactory(ssf);
		// 设置url请求方式 get or post
		connection.setRequestMethod(method);
		// 是否请求后重定向
		connection.setInstanceFollowRedirects(false);
		
		return connection;
	}
	
	/**
	 * <p>doHttpsUrlRequest</p>
	 * <p>执行Https请求</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param method
	 * @param requestHeaderMap
	 * @param outputStr
	 * @return
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String doHttpsUrlRequest(String urlStr, String method, 
			Map<String, String> requestHeaderMap, String outputStr) 
			throws KeyManagementException, NoSuchAlgorithmException, 
			NoSuchProviderException, IOException {
		StringBuffer buffer = new StringBuffer();
		HttpsURLConnection httpUrlConn = openHttpsUrlConnection(urlStr, method, requestHeaderMap);
		if ("GET".equalsIgnoreCase(method)){
			httpUrlConn.connect();
		}
		// 当有数据需要提交时
		if (null != outputStr) {
			OutputStream outputStream = httpUrlConn.getOutputStream();
			// 注意编码格式，防止中文乱码
			outputStream.write(outputStr.getBytes("UTF-8"));
			outputStream.close();
		}
		// 将返回的输入流转换成字符串
		InputStream inputStream = httpUrlConn.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		// 释放资源
		inputStream.close();
		inputStream = null;
		httpUrlConn.disconnect();
		return buffer.toString();
	}
 	
	/**
	 * <p>doHttpsUrlRequestReturnJson</p>
	 * <p>执行Https请求并获取结果</p>
	 * @author damon
	 * @date 2015年3月19日
	 * @param requestUrl 请求地址
	 * @param method 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static JSONObject doHttpsUrlRequestReturnJson(String urlStr, String method, 
			Map<String, String> requestHeaderMap, String outputStr) 
			throws KeyManagementException, NoSuchAlgorithmException, 
			NoSuchProviderException, IOException {
		JSONObject jsonObject = null;
		String result = doHttpsUrlRequest(urlStr, method, requestHeaderMap, outputStr);
		jsonObject = JSONObject.parseObject(result);
		return jsonObject;
	}
	
	/**
	 * <p>doGetHttpsURLRequestDefaultHeader</p>
	 * <p>执行GET https请求 默认请求头部</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String doGetHttpsURLRequestDefaultHeader(String urlStr, String outputStr) 
			throws IOException, KeyManagementException, NoSuchAlgorithmException, 
			NoSuchProviderException {
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		return doHttpsUrlRequest(urlStr, METHODS[0], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doGetHttpsURLRequest</p>
	 * <p>执行GET https请求</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param requestHeaderMap
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String doGetHttpsURLRequest(String urlStr, 
			Map<String, String> requestHeaderMap, String outputStr) throws IOException, 
			KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		return doHttpsUrlRequest(urlStr, METHODS[0], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doPostHttpsURLRequestDefaultHeader</p>
	 * <p>执行POST https请求 默认请求头部</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String doPostHttpsURLRequestDefaultHeader(String urlStr, String outputStr) 
			throws IOException, KeyManagementException, NoSuchAlgorithmException, 
			NoSuchProviderException {
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		return doHttpsUrlRequest(urlStr, METHODS[1], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doPostHttpsURLRequest</p>
	 * <p>执行POST https请求</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param requestHeaderMap
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static String doPostHttpsURLRequest(String urlStr, 
			Map<String, String> requestHeaderMap, String outputStr) throws IOException, 
			KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		return doHttpsUrlRequest(urlStr, METHODS[1], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doGetHttpsURLRequestDefaultHeaderReturnJson</p>
	 * <p>执行GET https请求 默认请求头部 返回JSON</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static JSONObject doGetHttpsURLRequestDefaultHeaderReturnJson(String urlStr, 
			String outputStr) throws IOException, KeyManagementException, 
			NoSuchAlgorithmException, NoSuchProviderException {
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		return doHttpsUrlRequestReturnJson(urlStr, METHODS[0], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doGetHttpsURLRequestReturnJson</p>
	 * <p>执行GET https请求 返回JSON</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param requestHeaderMap
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static JSONObject doGetHttpsURLRequestReturnJson(String urlStr, 
			Map<String, String> requestHeaderMap, String outputStr) throws IOException, 
			KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		return doHttpsUrlRequestReturnJson(urlStr, METHODS[0], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doPostHttpsURLRequestDefaultHeaderReturnJson</p>
	 * <p>执行POST https请求 默认请求头部 返回JSON</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static JSONObject doPostHttpsURLRequestDefaultHeaderReturnJson(String urlStr, 
			String outputStr) throws IOException, KeyManagementException, 
			NoSuchAlgorithmException, NoSuchProviderException {
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		return doHttpsUrlRequestReturnJson(urlStr, METHODS[1], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doPostHttpsURLRequestReturnJson</p>
	 * <p>执行POST https请求 返回JSON</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param requestHeaderMap
	 * @param outputStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static JSONObject doPostHttpsURLRequestReturnJson(String urlStr, 
			Map<String, String> requestHeaderMap, String outputStr) throws IOException, 
			KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		return doHttpsUrlRequestReturnJson(urlStr, METHODS[1], requestHeaderMap, outputStr);
	}
	
	public static String downloadFileByHttpsUrl(String urlStr, String pathName,
		Map<String, String> requestHeaderMap, String outputStr) throws KeyManagementException, 
		NoSuchAlgorithmException, NoSuchProviderException, IOException {
		HttpsURLConnection connection;
		connection = JavaRequestAndResponse.openHttpsUrlConnection(urlStr, 
				JavaRequestAndResponse.METHODS[0], requestHeaderMap);
		connection.connect();
		// 当有数据需要提交时
		if (null != outputStr) {
			OutputStream outputStream = connection.getOutputStream();
			// 注意编码格式，防止中文乱码
			outputStream.write(outputStr.getBytes("UTF-8"));
			outputStream.close();
		}
		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK
				|| responseCode == HttpURLConnection.HTTP_CREATED) {
			DataInputStream ins = new DataInputStream(connection.getInputStream());
			// 保存文件
			DataOutputStream dop = new DataOutputStream(
					new FileOutputStream(pathName));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = ins.read(buffer)) > 0) {
				dop.write(buffer, 0, count);
			}
			dop.close();
			ins.close();
			if (connection != null) {
				connection.disconnect();
			}
		}	
		return pathName;
	}
	
	public static String downloadFileByHttpsUrlDefaultHeader(String urlStr, String pathName,
			String outputStr) throws KeyManagementException, 
		NoSuchAlgorithmException, NoSuchProviderException, IOException {
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		return downloadFileByHttpsUrl(urlStr, pathName, requestHeaderMap, outputStr);
	}
	
	
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- HTTP 请求
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	/**
	 * <p>openHttpUrlConnection</p>
	 * <p>打开HttpURL连接</p>
	 * @author damon
	 * @date 2015年3月18日
	 */
	public static HttpURLConnection openHttpUrlConnection(String urlStr, String method, 
			Map<String, String> requestHeaderMap) throws IOException {
		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) openUrlConnection(urlStr, method, requestHeaderMap);

		// 设置url请求方式 get or post
		connection.setRequestMethod(method);
		// 是否请求后重定向
		connection.setInstanceFollowRedirects(false);
		
		return connection;
	}
	
	/**
	 * <p>doHttpUrlRequest</p>
	 * <p>执行Http请求</p>
	 * @author damon
	 * @date 2014年12月11日
	 * @param urlStr 请求链接
	 * @param method 请求方式
	 * @return 请求结果
	 * @throws IOException
	 */
	public static String doHttpUrlRequest(String urlStr, String method, 
			Map<String, String> requestHeaderMap, String outputStr) throws IOException {
		// 打开url连接
		HttpURLConnection connection = openHttpUrlConnection(urlStr, method, requestHeaderMap);
		if ("GET".equalsIgnoreCase(method)){
			connection.connect();
		}
		// 当有数据需要提交时
		if (null != outputStr) {
			OutputStream outputStream = connection.getOutputStream();
			// 注意编码格式，防止中文乱码
			outputStream.write(outputStr.getBytes("UTF-8"));
			outputStream.close();
		}
		// 返回结果
		String result = finishRequest(connection);
		return result;
	}
	
	/**
	 * <p>doGetHttpURLRequestDefaultHeader</p>
	 * <p>GET 请求</p>
	 * @author damon
	 * @date 2014年12月11日
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	public static String doGetHttpURLRequestDefaultHeader(String urlStr, String outputStr) throws IOException {
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		return doHttpUrlRequest(urlStr, METHODS[0], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doGetHttpURLRequest</p>
	 * <p>带请求头部参数的 GET 请求</p>
	 * @author damon
	 * @date 2015年3月17日
	 * @param urlStr
	 * @param requestHeaderMap
	 * @return
	 * @throws IOException
	 */
	public static String doGetHttpURLRequest(String urlStr, 
			Map<String, String> requestHeaderMap, String outputStr) throws IOException {
		return doHttpUrlRequest(urlStr, METHODS[0], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doPostHttpURLRequestDefaultHeader</p>
	 * <p>POST 请求</p>
	 * @author damon
	 * @date 2014年12月11日
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	public static String doPostHttpURLRequestDefaultHeader(String urlStr, String outputStr) throws IOException {
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		return doHttpUrlRequest(urlStr, METHODS[1], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doPostHttpURLRequest</p>
	 * <p>带请求头部参数的 POST 请求</p>
	 * @author damon
	 * @date 2015年3月17日
	 * @param urlStr
	 * @param requestHeaderMap
	 * @return
	 * @throws IOException
	 */
	public static String doPostHttpURLRequest(String urlStr, 
			Map<String, String> requestHeaderMap, String outputStr) throws IOException {
		return doHttpUrlRequest(urlStr, METHODS[1], requestHeaderMap, outputStr);
	}
	
	/**
	 * <p>doHttpPostFormData</p>
	 * <p></p>
	 * @author damon
	 * @date 2015年3月18日
	 * @param urlStr
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String doHttpPostFormData(String urlStr, Map<String, String> paramMap, Map<String, String> requestHeaderMap_) throws IOException {
		// 配置请求头部
		Map<String, String> requestHeaderMap = requestHeaderMap_;
		if(requestHeaderMap == null){
			requestHeaderMap = new HashMap<String, String>();
		}
		requestHeaderMap.put("content-type", "multipart/form-data; boundary=" + BOUNDARY);
		// 打开url连接
		HttpURLConnection connection = openHttpUrlConnection(urlStr, METHODS[1], requestHeaderMap);

		// 写流
		OutputStream out = new DataOutputStream(connection.getOutputStream());
		
		// 文本内容
		writeParams(paramMap, out);
		
		// 关闭out
		out.flush();
		out.close();
		
		// 返回结果
		String result = finishRequest(connection);
		return result;
	}
	
	/**
	 * <p>doHttpPostFormDataWithFileBytes</p>
	 * <p>POST 带附件流的form</p>
	 * @author damon
	 * @date 2015年3月18日
	 * @param urlStr
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String doHttpPostFormDataWithFileBytes(String urlStr, Map<String, String> paramMap, 
			byte[] fileBytes, String contentType) throws IOException {
		// 配置请求头部
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		requestHeaderMap.put("content-type", "multipart/form-data; boundary=" + BOUNDARY);
		// 打开url连接
		HttpURLConnection connection = openHttpUrlConnection(urlStr, METHODS[1], requestHeaderMap);

		// 写流
		OutputStream out = new DataOutputStream(connection.getOutputStream());
		
		// 文本内容
		writeParams(paramMap, out);
		
		// 文件流
		if(fileBytes != null) {
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
			strBuf.append("Content-Disposition: form-data; name=\""
					+ "upload" + "\"; filename=\"" + "yanzhengma"
					+ "\"\r\n");
			strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
			out.write(strBuf.toString().getBytes());
			out.write(fileBytes);
		}
		// 结束字节
		byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
		out.write(endData);
		
		// 关闭out
		out.flush();
		out.close();
        
		// 返回结果
		String result = finishRequest(connection);
		return result;
	}
	
	/**
	 * <p>doHttpPostFormDataWithFilePath</p>
	 * <p>POST 带附件的form</p>
	 * @author damon
	 * @date 2015年3月18日
	 * @param urlStr
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String doHttpPostFormDataWithFilePath(String urlStr, Map<String, String> paramMap, 
			String filePath, String contentType) throws IOException {
		// 配置请求头部
		Map<String, String> requestHeaderMap = new HashMap<String, String>();
		requestHeaderMap.put("content-type", "multipart/form-data; boundary=" + BOUNDARY);
		// 打开url连接
		HttpURLConnection connection = openHttpUrlConnection(urlStr, METHODS[1], requestHeaderMap);

		// 写流
		OutputStream out = new DataOutputStream(connection.getOutputStream());
		
		// 文本内容
		writeParams(paramMap, out);
		
		// 文件
		if(filePath != null) {
			File file = new File(filePath);
			String filename = file.getName();
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
			strBuf.append("Content-Disposition: form-data; name=\""
					+ "upload" + "\"; filename=\"" + filename + "\"\r\n");
			strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
			out.write(strBuf.toString().getBytes());
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			in.close();
//			System.out.println(strBuf.toString());
		}
		
		// 结束字节
		byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
		out.write(endData);
		
		// 关闭out
		out.flush();
		out.close();
        
		// 返回结果
		String result = finishRequest(connection);
		return result;
	}
	
	/**
	 * <p>writeParams</p>
	 * <p>写普通表单数据</p>
	 * @author damon
	 * @date 2015年3月18日
	 * @param paramMap
	 * @param out
	 * @throws IOException
	 */
	private static void writeParams(Map<String, String> paramMap, OutputStream out) throws IOException {
		// 文本内容
		if(paramMap != null) {
			StringBuffer strBuf = new StringBuffer();
			Iterator<Entry<String, String>> iter = paramMap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = iter.next();
				String inputName = entry.getKey();
				String inputValue = entry.getValue();
				strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
				strBuf.append("Content-Disposition: form-data; name=\""
						+ inputName + "\"\r\n\r\n");
				strBuf.append(inputValue);
			}
			out.write(strBuf.toString().getBytes());
//			System.out.println(strBuf.toString());
		}
	}
	
	/**
	 * <p>finishRequest</p>
	 * <p>返回请求结果</p>
	 * @author damon
	 * @date 2015年3月18日
	 * @return
	 * @throws IOException 
	 */
	private static String finishRequest(HttpURLConnection connection) throws IOException {
		StringBuffer buffer = new StringBuffer();
		// 将返回的输入流转换成字符串
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		// 释放资源
		inputStream.close();
		inputStream = null;
		connection.disconnect();
		// 返回发送结果
		String inputline = buffer.toString();
		return inputline;
	}
	
	/**
	 * <p>downloadFileByHttpUrl</p>
	 * <p>通过资源URL下载文件</p>
	 * @author damon
	 * @date 2015年3月24日
	 * @param urlStr
	 * @param pathName
	 * @param requestHeaderMap
	 * @return
	 * @throws IOException 
	 */
	public static String downloadFileByHttpUrl(String urlStr, String pathName,
		Map<String, String> requestHeaderMap) throws IOException {
		HttpURLConnection connection;
		connection = JavaRequestAndResponse.openHttpUrlConnection(urlStr, 
				JavaRequestAndResponse.METHODS[0], requestHeaderMap);
		connection.connect();
		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK
				|| responseCode == HttpURLConnection.HTTP_CREATED) {
			DataInputStream ins = new DataInputStream(connection.getInputStream());
			// 保存文件
			DataOutputStream dop = new DataOutputStream(
					new FileOutputStream(pathName));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = ins.read(buffer)) > 0) {
				dop.write(buffer, 0, count);
			}
			dop.close();
			ins.close();
			if (connection != null) {
				connection.disconnect();
			}
		}	
		return pathName;
	}
	
	/**
	 * <p>getFileBytesByHttpUrl</p>
	 * <p>通过资源URL获取文件字节集 亦可同时下载到本地</p>
	 * @author damon
	 * @date 2015年4月13日
	 * @param urlStr
	 * @param requestHeaderMap
	 * @param pathName
	 * @return
	 * @throws IOException
	 */
	public static byte[] getFileBytesByHttpUrl(String urlStr, Map<String, String> requestHeaderMap, 
			String pathName) throws IOException {
		HttpURLConnection connection;
		connection = JavaRequestAndResponse.openHttpUrlConnection(urlStr, 
				JavaRequestAndResponse.METHODS[0], requestHeaderMap);
		connection.connect();
		byte[] bytes = new byte[0];
		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK
				|| responseCode == HttpURLConnection.HTTP_CREATED) {
			DataInputStream ins = new DataInputStream(connection.getInputStream());
			//写入字节数组
			ByteArrayOutputStream dop = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = ins.read(buffer)) > 0) {
				dop.write(buffer, 0, count);
			}
			bytes = dop.toByteArray();
			dop.close();
			ins.close();
			if(pathName!=null){//需要保存文件
				@SuppressWarnings("resource")
				DataOutputStream out = new DataOutputStream(new FileOutputStream(pathName));
				out.write(bytes);
				out.flush();
			}
			if (connection != null) {
				connection.disconnect();
			}
		}	
		return bytes;
	}
	
	public static void main(String[] args) {
		Map<String, String> requestHeaderMap_ = new HashMap<String, String>();
		requestHeaderMap_.put("Accept-Language", "zh-cn,zh;q=0.5");
//		String url = "http://www.jsdati.com/include/class/authcode.class.php?_="+Math.random();
		String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEQ8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL3BraEE1MERsTEZKVng4OGM2V1JQAAIEOEdkVQMEAAAAAA==";
		try {
			JavaRequestAndResponse.downloadFileByHttpUrl(url, "E:/"+System.currentTimeMillis()+".jpg", requestHeaderMap_);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		try {
//			JavaRequestAndResponse.downloadFileByHttpsUrl(url, "d:/1.jpg", requestHeaderMap_,"");
//		} catch (KeyManagementException | NoSuchAlgorithmException
//				| NoSuchProviderException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- response
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	//-- ---------------------------------------------------------------- --//
	/**
	 * <p>response</p>
	 * <p>响应消息，返回结果</p>
	 * @author damon
	 * @date 2014年12月19日
	 * @param os
	 * @param result
	 * @throws IOException
	 */
	public static void response(OutputStream os, String result)
			throws IOException {
		os.write(result.getBytes("UTF-8"));
		os.flush();
		os.close();
	}
	
}
