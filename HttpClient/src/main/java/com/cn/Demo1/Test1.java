package com.cn.Demo1;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

class Test1 {

    public static void main(String[] args) {
        String userName = "瓜不甜";
        String password = "Xjt@54007";
        String loginUrl = "http://passport.cnblogs.com/login.aspx";
        String dataUrl = "http://home.cnblogs.com/";
        HttpClientLogin(userName, password, loginUrl, dataUrl);
    }

    private static void HttpClientLogin(String userName, String password,
                                        String loginUrl, String dataUrl) {


        long startTime = System.currentTimeMillis();    //获取开始时间

        HttpClient httpClient = new HttpClient();
        //设置参数
        httpClient.getParams().setParameter(
                HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        httpClient.getParams().setCookiePolicy(
                CookiePolicy.BROWSER_COMPATIBILITY);


        //PSOT方法
        PostMethod postMethod = new PostMethod(loginUrl);

        //POST数据
        NameValuePair[] postData = {new NameValuePair("tbUserName", userName),
                new NameValuePair("tbPassword", password)};

        //填充数据
        postMethod.setRequestBody(postData);


        try {


            //运行，获取网页数据
            httpClient.executeMethod(postMethod);

            //获取cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer stringBuffer = new StringBuffer();
            for (Cookie c : cookies) {
                stringBuffer.append(c.toString() + ";");
            }

            //再次运行时，带cookie
            GetMethod getMethod = new GetMethod(dataUrl);
            getMethod.setRequestHeader("Cookie", stringBuffer.toString());
            postMethod.setRequestHeader("Host", "passport.cnblogs.com");
            postMethod.setRequestHeader("Referer", "http://home.cnblogs.com/");
            postMethod.setRequestHeader("User-Agent", "AndroidCnblogs");


            httpClient.executeMethod(getMethod);

            String result = getMethod.getResponseBodyAsString();
            long endTime = System.currentTimeMillis();    //获取结束时间

            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

