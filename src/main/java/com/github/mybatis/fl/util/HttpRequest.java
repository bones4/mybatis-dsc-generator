package com.github.mybatis.fl.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 利用HttpClient进行post请求的工具类
 */

public final class HttpRequest {


	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 *
	 * @param url         请求的URL地址
	 * @return 返回请求响应的HTML
	 */
	public static String doGet(String url) {
		String strResult = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse;
		try {
			httpResponse = client.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				// 第3步：使用getEntity方法获得返回结果
				strResult = EntityUtils.toString(httpResponse.getEntity());
				// 去掉返回结果中的"\r"字符，
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strResult;
	}


	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 *
	 * @param url    请求的URL地址
	 * @param params 请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static String doPost(String url, Map<String, String> params)
			throws IllegalStateException, IOException {
		String strResult = "";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			postData.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));
			System.out.print(entry.getValue());
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData, HTTP.UTF_8);//过时了?
		post.setEntity(entity);
		HttpResponse response = httpClient.execute(post);
		// 若状态码为200 ok
		if (response.getStatusLine().getStatusCode() == 200) {
			// 取出回应字串
			strResult = EntityUtils.toString(response.getEntity());
		}
		return strResult;
	}


	public static void main(String[] args) throws IllegalStateException,
			IOException {
		HashMap<String, String> user = new HashMap<String, String>();
		user.put("username", "admin");
		user.put("password", "123");
		String post = doPost("http://127.0.0.1/html4/login_mobile.php", user);
		String get = doGet("http://127.0.0.1/html4/login_mobile.php");
		System.out.println("Post:" + post);
		System.out.println("Get:" + get);
	}
}