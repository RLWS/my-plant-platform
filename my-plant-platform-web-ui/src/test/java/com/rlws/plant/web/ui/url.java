package com.rlws.plant.web.ui;

import com.rlws.plant.commons.utils.HttpclientUtils;
import org.junit.Test;

public class url {
    @Test
    public void doGet(){
        String s = HttpclientUtils.get("https://map.baidu.com/?qt=sub_area_list&areaname=兰州市&level=1&from=mapapi");
        System.out.println(s);
    }

    @Test
    public void tset01(){
        int a = 1123;
        boolean b = true;
        byte b1 = 12;
        double b2 = 123.12;
        float f = 123.92F;
        short s = 1;
        long l = 12354345L;
        Object[] objects = {a,b,b1,b2,f,s,l};
        for (Object o : objects){
            System.out.println(o.toString());
        }
    }
}
