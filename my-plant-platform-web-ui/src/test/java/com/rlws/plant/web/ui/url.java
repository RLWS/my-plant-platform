package com.rlws.plant.web.ui;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import org.junit.Test;

public class url {
    @Test
    public void doGet(){
        String s = HttpclientUtils.get("https://map.baidu.com/?qt=sub_area_list&areaname=兰州市&level=1&from=mapapi");
        System.out.println(s);
    }
}
