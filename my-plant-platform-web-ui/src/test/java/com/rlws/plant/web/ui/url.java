package com.rlws.plant.web.ui;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import org.junit.Test;

public class url {
    @Test
    public void doGet(){
        String s = HttpclientUtils.get("http://127.0.0.1:8081/api/test?email=123@qq.com");
        System.out.println(s);
    }
}
