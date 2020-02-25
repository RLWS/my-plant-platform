package com.rlws.plant.commons.utils;

import java.io.*;

/**
 * @author rlws
 * @date 2020/2/24  10:59
 */
public class SerializeUtils {
    /**
     * 序列化某个类并返回序列化后的字符串
     *
     * @param obj 需要序列化的类
     * @return 序列化后的字符串
     */
    public static String serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        byte[] result = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return toHexString(result);
    }

    /**
     * 将字符串反序列化为某个类
     *
     * @param str 需要反序列化的字符串
     * @return 返回反序列化的类
     * @throws IOException            IO异常
     * @throws ClassNotFoundException 类缺失异常
     */
    public static Object unSerialize(String str) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(toByteArray(str));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return object;
    }

    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param byteArray 需要转换的字节数组
     * @return 16进制表示格式的字符串
     */
    private static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1) {
            throw new IllegalArgumentException("this byteArray must not be null or empty");
        }
        StringBuilder hexString = new StringBuilder();
        for (byte b : byteArray) {
            //0-F前面补零
            if ((b & 0xff) < 0x10) {
                hexString.append("0");
            }
            hexString.append(Integer.toHexString(0xff & b));
        }
        return hexString.toString();
    }

    /**
     * 将16进制表示格式的字符串转换成字节数组
     *
     * @param hexString 16进制表示格式的字符串
     * @return 字节数组
     */
    private static byte[] toByteArray(String hexString) {
        if (hexString == null || hexString.trim().length() == 0) {
            throw new IllegalArgumentException("this hexString must not be null or empty");
        }
        byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        //因为是16进制,最多只会占用4位,转换成字节需要两个16进制的字符,高位在先
        for (int i = 0; i < byteArray.length; i++) {
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }
}
