package com.lfs.http.httpclient;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p><b>Title:</b><i>通过GET 方式请求</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class HttpClientGet {
	
private static final OkHttpClient mOkHttpClient = new OkHttpClient();
	
	
    static{
        mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
    }
    
    
    public static String getReqBuild(HttpUrl.Builder urlBuilder)throws IOException{
    	Request.Builder reqBuild = new Request.Builder();
		reqBuild.url(urlBuilder.build());
			Response response = OkHttpUtil.execute(reqBuild.build());
	        if (response.isSuccessful()) {
	            String responseUrl = response.body().string();
	            return responseUrl;
	        } else {
	            throw new IOException("Unexpected code " + response);
	        }
    }

    
    public static String getStringFromServer(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = OkHttpUtil.execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
    
    
    public static String getStringFromServer(String url, List<BasicNameValuePair> params) throws IOException{
    	url = OkHttpUtil.attachHttpGetParams(url, params);
        Request request = new Request.Builder().url(url).build();
        Response response = OkHttpUtil.execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

}
