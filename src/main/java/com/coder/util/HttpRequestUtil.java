package com.coder.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class HttpRequestUtil {

    private static String encoding = "utf-8";


    public static String get(String url, Map<String, String> param) {
        HttpClient httpClient = getClient(false);
        String responseText = "";
        HttpResponse httpResponse = null;

        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Connection", "Keep-Alive");
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

            RequestConfig requestConfig = RequestConfig.custom().
                    setSocketTimeout(5000).
                    setConnectTimeout(5000).
                    build();
            httpGet.setConfig(requestConfig);

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if (param != null) {
                for (String k : param.keySet()) {
                    nvps.add(new BasicNameValuePair(k, param.get(k)));
                }
            }
            String paramstr = EntityUtils.toString(new UrlEncodedFormEntity(nvps, encoding));
            httpGet.setURI(new URIBuilder(httpGet.getURI().toString() + "&" + paramstr).build());
            System.out.println("请求信息：" + httpGet);
            httpResponse = httpClient.execute(httpGet);
            System.out.println("响应信息：" + httpResponse);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                responseText = EntityUtils.toString(httpResponse.getEntity(), encoding);
            } else {
                System.out.println(httpResponse.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseText;
    }


    private static HttpClient getClient(boolean isSSL) {
        return getClient(isSSL, 80);
    }

    private static HttpClient getClient(boolean isSSL, final int port) {

        HttpClient httpClient = new DefaultHttpClient();

        if (isSSL) {
            X509TrustManager xtm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            try {
                SSLContext ctx = SSLContext.getInstance("TLS");

                ctx.init(null, new TrustManager[]{xtm}, new SecureRandom());

                SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
                socketFactory.setHostnameVerifier(new AllowAllHostnameVerifier());

                httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", port, socketFactory));

            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        return httpClient;
    }
}