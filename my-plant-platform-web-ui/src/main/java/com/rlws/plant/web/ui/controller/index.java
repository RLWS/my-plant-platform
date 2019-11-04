package com.rlws.plant.web.ui.controller;

import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Controller
public class index {

    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        String email = "123@qq.com";
        String s = HttpclientUtils.get("http://127.0.0.1:8081/api/v1/test?email=" + email);
        return s;
    }

    @RequestMapping(value = {"rlws"}, method = RequestMethod.GET)
    @ResponseBody
    public String postTest() {
        String email = "123@qq.com";
        String url = "http://127.0.0.1:8081/api/v1/rlws";
        HashMap map = new HashMap<String, String>();
        map.put("email", email);
        map.put("email", email);
        String s = HttpclientUtils.post(url, map);
        return s;
    }

    public static void main(String[] args) {
        //https://map.baidu.com/?qt=sub_area_list&areacode=1&level=1&from=mapapi
        //String email = "123@qq.com";
        /*String url = "https://map.baidu.com/";
        HashMap map = new HashMap<String, String>();
        map.put("qt", "sub_area_list");
        map.put("areacode", "1");
        map.put("level", "1");
        map.put("from", "mapapi");
        String s = HttpclientUtils.post(url, map);
        System.out.println();*/

        String s = HttpclientUtils.get("https://map.baidu.com/?qt=sub_area_list&areacode=1&level=1&from=mapapi");
        System.out.println(s);

    }

    public static String getWeatherInfo(String url) {
        CloseableHttpClient client;
        client = HttpClients.createDefault();

        HttpGet get = new HttpGet(url);
        HttpResponse response;
        try {
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instreams = entity.getContent();
                String str = convertStreamToString(instreams);
                get.abort();
                return str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String convertStreamToString(InputStream is) {
        StringBuilder sb1 = new StringBuilder();
        byte[] bytes = new byte[4096];
        int size;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }
}
