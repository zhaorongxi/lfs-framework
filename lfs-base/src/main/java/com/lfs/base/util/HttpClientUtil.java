package com.lfs.base.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class HttpClientUtil {

    private static final Logger Log = LoggerFactory.getLogger(HttpClientUtil.class);

    public static final ContentType CONTENTTYPE_TEXTPLAIN = ContentType.create("text/plain", Consts.UTF_8);

    private static final int SOCKET_TIMOUT = 1000 * 60;

    private static final int CONNECT_TIMOUT = 1000 * 5;

    private volatile static CloseableHttpAsyncClient httpclient;

    private volatile static CloseableHttpClient syncHttpclient;

    private static final Lock lockAsync = new ReentrantLock();

    private static final Lock lockSync = new ReentrantLock();

    public static CloseableHttpAsyncClient getAsyncClient() {
        if (null == httpclient) {
            if (lockAsync.tryLock()) {
                if (null == httpclient) {
                    try {
                        SSLContext sslcontext = getSSLContext();
                        sslcontext.init(null, new TrustManager[] { trustManager }, null);
                        SSLIOSessionStrategy sslSessionStrategy = new SSLIOSessionStrategy(sslcontext, new String[] {
                                "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" }, null, NoopHostnameVerifier.INSTANCE);
                        IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setConnectTimeout(CONNECT_TIMOUT)
                                .setSoTimeout(SOCKET_TIMOUT).build();
                        httpclient = HttpAsyncClients
                                .custom()
                                .setUserAgent("http-ruitone")
                                .setSSLStrategy(sslSessionStrategy)
                                .setMaxConnPerRoute(10)
                                .setMaxConnTotal(100)
                                .setDefaultIOReactorConfig(ioReactorConfig)
                                .setDefaultRequestConfig(
                                        RequestConfig.custom().setConnectTimeout(CONNECT_TIMOUT)
                                                .setSocketTimeout(SOCKET_TIMOUT).build())
                                .setDefaultConnectionConfig(
                                        ConnectionConfig.custom().setCharset(Charset.forName("UTF-8"))
                                                .build()).disableAuthCaching().disableCookieManagement().build();
                    } catch (Exception e) {
                        Log.error(e.getMessage(), e);
                    }
                }
                lockAsync.unlock();
            }
        }
        return httpclient;
    }

    public static CloseableHttpClient getSyncClient() {
        if (null == syncHttpclient) {
            if (lockSync.tryLock()) {
                if (null == syncHttpclient) {
                    try {
                        SSLContext sslcontext = getSSLContext();
                        sslcontext.init(null, new TrustManager[] { trustManager }, null);
                        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                                sslcontext, new String[] { "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" }, null,
                                NoopHostnameVerifier.INSTANCE);
                        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(SOCKET_TIMOUT).build();
                        syncHttpclient = HttpClients
                                .custom()
                                .setUserAgent("http-ruitone")
                                .setSSLSocketFactory(sslConnectionSocketFactory)
                                .setMaxConnPerRoute(10)
                                .setMaxConnTotal(100)
                                .setDefaultSocketConfig(socketConfig)
                                .setDefaultRequestConfig(
                                        RequestConfig.custom().setConnectTimeout(CONNECT_TIMOUT)
                                                .setSocketTimeout(SOCKET_TIMOUT).build())
                                .setDefaultConnectionConfig(
                                        ConnectionConfig.custom().setCharset(Charset.forName("UTF-8"))
                                                .build()).disableAuthCaching().disableCookieManagement().build();
                    } catch (Exception e) {
                        Log.error(e.getMessage(), e);
                    }
                }
                lockSync.unlock();
            }
        }
        return syncHttpclient;
    }

    private static SSLContext getSSLContext() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("SSL");
    }

    // 自定义私有类
    private final static TrustManager trustManager = new X509TrustManager() {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };
    
    public static String requestByGetMethod(Map<String,String> params,String url){
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse httpResponse = null;
        try {
        	Set keys = params.keySet();
			url = url + "?";
			for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
				String key = iterator.next();
				url += key + "=" + params.get(key) + "&";
			}
			url = url.substring(0, url.length() - 1);
            HttpGet get = new HttpGet(url);
            Log.info("校验通执行get请求:...."+get.getURI());
            httpResponse = httpClient.execute(get);
            HttpEntity entity = httpResponse.getEntity();
            if(httpResponse.getStatusLine().getStatusCode()==200){
            	return EntityUtils.toString(entity);
            }else{
            	return "EX";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "EX";
        }
        finally{
            try{
            	httpResponse.close();
                closeHttpClient(httpClient);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
 
    }
    private static CloseableHttpClient getHttpClient(){
        return HttpClients.createDefault();
    }
     
    private static void closeHttpClient(CloseableHttpClient client) throws IOException{
        if (client != null){
            client.close();
        }
    }

}
