package com.saintlu.common.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author quan
 * @date 2020-11-25 9:57
 */

public class HttpUtil {

    public static String doWxCertsRequest(String requestUrl, InputStream in, String mchId,
                                          String params) throws  Exception{
        String text = "";
        // 指定读取证书格式为PKCS12
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        // 读取本机存放的PKCS12证书文件
        try {
            // 指定PKCS12的密码(商户ID)
            keyStore.load(in, mchId.toCharArray());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpClient httpclient = HttpClients
                .custom()
                .setDefaultRequestConfig(RequestConfig.custom().setConnectionRequestTimeout(5000).build())
                .setSSLSocketFactory(sslsf)
                .build();

        try {
            HttpPost post = new HttpPost(requestUrl);
            StringEntity s = new StringEntity(params, "utf-8");
            s.setContentType("application/xml");

            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            HttpEntity entity = res.getEntity();
            text = EntityUtils.toString(entity, "utf-8");
        } finally {
            httpclient.close();
        }
        return text;
    }


    public static String doPost(String url, Map params) {
        BufferedReader in = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            List<NameValuePair> nvps = new ArrayList<>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

            }
            request.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {//success
                in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                return sb.toString();
            } else {
                System.out.println("status：" + code);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
