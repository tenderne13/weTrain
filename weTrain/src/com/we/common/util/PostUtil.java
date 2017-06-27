package com.we.common.util;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;




import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PostUtil {
	 /** 
     * 重写验证方法，取消检测ssl 
     */  
    private static TrustManager truseAllManager = new X509TrustManager(){  
  
        public void checkClientTrusted(  
                java.security.cert.X509Certificate[] arg0, String arg1)  
                throws CertificateException {  
            // TODO Auto-generated method stub  
              
        }  
  
        public void checkServerTrusted(  
                java.security.cert.X509Certificate[] arg0, String arg1)  
                throws CertificateException {  
            // TODO Auto-generated method stub  
              
        }  
  
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {  
            // TODO Auto-generated method stub  
            return null;  
        }  
          
    }; 
	/** 
     * 访问https的网站 
     * @param httpclient 
     */  
    private static void enableSSL(DefaultHttpClient httpclient){  
        //调用ssl  
         try {  
                SSLContext sslcontext = SSLContext.getInstance("TLS");  
                sslcontext.init(null, new TrustManager[] { truseAllManager }, null);  
                SSLSocketFactory sf = new SSLSocketFactory(sslcontext);  
                sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
                Scheme https = new Scheme("https", sf, 443);  
                httpclient.getConnectionManager().getSchemeRegistry().register(https);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
    }  
    
    
    /**
	 * 
	 * @param url
	 * @return
	 */
	public static JSONObject doGetStr(String url){
		DefaultHttpClient httpClient=new DefaultHttpClient();
		enableSSL(httpClient);
		HttpGet httpGet=new HttpGet(url);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
		httpGet.setHeader("Cookie", "csrftoken=7a8ff9104928400b1f3bb3cf817c4c09; tt_webid=45941158016; uuid=\"w:35c4134fab6b4b559025c5980b2d222c\";CNZZDATA1259612802=520397086-1482926766-https%253A%252F%252Fwww.baidu.com%252F%7C1484749602; sso_login_status=0;sessionid=13ca9ee794cde4c5c7ca8677ce782061; sid_guard=\"13ca9ee794cde4c5c7ca8677ce782061|1484751363|2592000|Fri\054 17-Feb-2017 14:56:03 GMT\";_ga=GA1.2.1973932152.1482931517;cp=58631B3E1BB1DE1;sid_tt"+
"=13ca9ee794cde4c5c7ca8677ce782061; __tasessionId=ifpjy1wm71484750886425; utm_source=toutiao; login_flag"+
"=07dc5d177005e5179e2f347dcdb5e423");
		System.out.println(httpGet.getHeaders("Cookie"));
		JSONObject jsonObject=null;
		try {
			HttpResponse response=httpClient.execute(httpGet);
			HttpEntity entity=response.getEntity();
			if(entity!=null){
				String result =EntityUtils.toString(entity,"UTF-8");
				jsonObject=JSONObject.parseObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String doGetString(String url){
		DefaultHttpClient httpClient=new DefaultHttpClient();
		enableSSL(httpClient);
		HttpGet httpGet=new HttpGet(url);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
		httpGet.setHeader("Cookie", "csrftoken=7a8ff9104928400b1f3bb3cf817c4c09; tt_webid=45941158016; uuid=\"w:35c4134fab6b4b559025c5980b2d222c\";CNZZDATA1259612802=520397086-1482926766-https%253A%252F%252Fwww.baidu.com%252F%7C1484749602; sso_login_status=0;sessionid=13ca9ee794cde4c5c7ca8677ce782061; sid_guard=\"13ca9ee794cde4c5c7ca8677ce782061|1484751363|2592000|Fri\054 17-Feb-2017 14:56:03 GMT\";_ga=GA1.2.1973932152.1482931517;cp=58631B3E1BB1DE1;sid_tt"+
"=13ca9ee794cde4c5c7ca8677ce782061; __tasessionId=ifpjy1wm71484750886425; utm_source=toutiao; login_flag"+
"=07dc5d177005e5179e2f347dcdb5e423");
		String result=null;
		try {
			HttpResponse response=httpClient.execute(httpGet);
			HttpEntity entity=response.getEntity();
			if(entity!=null){
				result =EntityUtils.toString(entity,"GBK");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static JSONObject doPostStr(String url,String outStr){
		DefaultHttpClient httpClient=new DefaultHttpClient();
		enableSSL(httpClient);
		HttpPost httpPost=new HttpPost(url);
		JSONObject jsonObject=null;
		try {
			httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
			HttpResponse response=httpClient.execute(httpPost);
			String result=EntityUtils.toString(response.getEntity(),"UTF-8");
			jsonObject=JSON.parseObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	public static void main(String[] args) {
		String url ="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2017-06-27&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=BMP&purpose_codes=ADULT";
		System.out.println(doGetString(url));
	}
}
