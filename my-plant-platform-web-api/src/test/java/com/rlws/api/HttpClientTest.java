package com.rlws.api;

import com.rlws.plant.web.api.service.UserService;
import com.rlws.plant.web.api.service.impl.UserServiceImpl;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class HttpClientTest {

    private final String Connection = "keep-alive";

    private final String User_Agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36";

    @Test
    public void getTest() throws IOException {
        //创建客户端,也就是'浏览器'
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //创建get请求并设置uri
        HttpGet httpGet = new HttpGet("http://www.drmarket.cn/weChat-Server/search/queryPreferentialArea");
        //设置Cookie(补充:Session其实就是保存在服务器中的Cookie)
        httpGet.addHeader("Cookie","");
        //长连接
        httpGet.addHeader("Connection",Connection);
        //浏览器设置
        httpGet.addHeader("User-Agent",User_Agent);
        //发起get请求
        CloseableHttpResponse execute = httpClient.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        //获取返回的数据
        String s = EntityUtils.toString(entity);
        System.out.println(s);
        //关闭客户端
        httpClient.close();
    }

    public void postTest() throws IOException{
        //创建客户端,也就是'浏览器'
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //创建post请求并设置uri
        HttpPost httpPost = new HttpPost("");
        //设置参数集合
        List prams = new ArrayList<NameValuePair>();
        prams.add(new BasicNameValuePair("a","b"));
        prams.add(new BasicNameValuePair("b","b"));
        prams.add(new BasicNameValuePair("c","b"));
        //填入参数
        httpPost.setEntity(new UrlEncodedFormEntity(prams,"utf-8"));
        //设置Cookie(补充:Session其实就是保存在服务器中的Cookie)
        httpPost.addHeader("Cookie","");
        //长连接
        httpPost.addHeader("Connection",Connection);
        //浏览器设置
        httpPost.addHeader("User-Agent",User_Agent);
        //发起post请求
        CloseableHttpResponse execute = httpClient.execute(httpPost);
        HttpEntity entity = execute.getEntity();
        //获取返回的数据
        String s = EntityUtils.toString(entity);
        System.out.println(s);
        //关闭客户端
        httpClient.close();
    }

    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i< 30 ;i ++){
            int rd = random.nextInt(100);
            list.add(rd);
        }
        list.forEach(e ->{
            System.out.println(e);
        });
        new Thread(()->{
            System.out.println("匿名内部类!");
        }).start();
        list.stream().map(x -> x + x * 0.5).forEach(x -> System.out.println(x));
    }

}
