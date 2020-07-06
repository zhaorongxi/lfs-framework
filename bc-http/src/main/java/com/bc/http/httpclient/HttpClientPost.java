package com.bc.http.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p><b>Title:</b><i>通过POST 方式请求</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class HttpClientPost {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientPost.class);





	/**
	 * author chent42@vanke.com
	 * 2018-9-19
	 * 
	 */
	public static JSONObject sendPost(String pathUrl, String requestString) throws Exception{
		JSONObject json = new JSONObject();
		logger.info("##########启用httpPost开始，调用地址："+pathUrl);
		long startTime = System.currentTimeMillis();

		URL url = new URL(pathUrl);
		HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
		// 设置连接属性
		// 使用 URL 连接进行输出
		httpUrlConnection.setDoOutput(true);
		// 使用 URL 连接进行输入
		httpUrlConnection.setDoInput(true);
		// 忽略缓存
		httpUrlConnection.setUseCaches(false);
		// 设置URL请求方法
		httpUrlConnection.setRequestMethod("POST");
		httpUrlConnection.setRequestProperty("CHARSET", "UTF-8");
		// 设置请求属性
		// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
		byte[] requestStringBytes = requestString.getBytes("UTF-8");
		httpUrlConnection.setRequestProperty("Content-length", "" + requestStringBytes.length);
		httpUrlConnection.setRequestProperty("Content-Type", "application/json");
		// 维持长连接
		httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
		httpUrlConnection.setRequestProperty("Charset", "UTF-8");

		// 建立输出流，并写入数据
		OutputStream outputStream = httpUrlConnection.getOutputStream();
		outputStream.write(requestStringBytes);
		outputStream.close();
		// 获得响应状态
		int responseCode = httpUrlConnection.getResponseCode();
		String readLine = null;
		// 连接成功
		if (HttpURLConnection.HTTP_OK == responseCode) {
			// 当正确响应时处理数据
			StringBuffer sb = new StringBuffer();

			BufferedReader responseReader;
			// 处理响应流，必须与服务器响应流输出的编码一致
			responseReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			while ((readLine = responseReader.readLine()) != null) {
				sb.append(readLine).append("\n");
			}
			responseReader.close();
			String result = sb.toString();
			// 处理返回的参数
			if (!"".equals(result)) {
				json = JSONObject.parseObject(result);
			}
		}
		json.put("HTTP_CODE", responseCode);
		long endTime = System.currentTimeMillis();
		// 打印耗时的信息
		logger.info("##########启用httpPost开始，调用地址："+pathUrl);
		logger.info("\n##########httpPost调用结束，返回报文："+json+"，当次执行时间为：【"+  ( endTime - startTime)/1000.0+"秒】"  );
		return json;
	}
}
