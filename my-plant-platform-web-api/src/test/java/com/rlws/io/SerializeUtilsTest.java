package com.rlws.io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.SerializeUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author rlws
 * @date 2020/2/24  13:07
 */
public class SerializeUtilsTest {
    @Test
    public void test01() throws IOException, ClassNotFoundException {
        String serialize = SerializeUtils.serialize(BaseResult.success("但是葡萄表面的那层白霜就是那么讨人喜欢了，很多朋友对于葡萄表面的这层白霜颇有意见，最近，“葡萄感染各种真菌，果农会喷洒很多很多的农药，一定要清洗干净”的传言四起，于是乎，这层白霜就被大多数人当成了农药残留的标志。"));
        BaseResult baseResult = (BaseResult) SerializeUtils.unSerialize(serialize);
        System.out.println(baseResult.getStatus());
        System.out.println(baseResult.getMessage());
        System.out.println(baseResult.getData());
    }

    @Test
    public void test02() {
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(BaseResult.success("但是葡萄表面的那层白霜就是那么讨人喜欢了，很多朋友对于葡萄表面的这层白霜颇有意见，最近，“葡萄感染各种真菌，果农会喷洒很多很多的农药，一定要清洗干净”的传言四起，于是乎，这层白霜就被大多数人当成了农药残留的标志。")));
        System.out.println(jsonObject.getString("status"));
        System.out.println(jsonObject.getString("message"));
        System.out.println(jsonObject.getString("data"));
    }

    @Test
    public void test03() throws IOException, ClassNotFoundException {
        long startTime=System.currentTimeMillis();   //获取开始时间
        for (int i = 0; i < 50000; i++) {
            test01();
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    @Test
    public void test04(){
        byte b = -84;
        int i = b & 0xff;
        System.out.println(i);//结果等于172
    }

    @Test
    public void test05(){
        int a = Character.digit('c', 16);
        System.out.println(a);
    }

    @Test
    public void test06(){
        byte b1 = 10;
        byte b2 = 12;
        byte i = (byte) (b1 << 4 | b2);
        System.out.println(i);
    }
}
