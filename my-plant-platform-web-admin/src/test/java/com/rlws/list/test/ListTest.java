package com.rlws.list.test;

import com.rlws.plant.domain.User;
import org.junit.Test;

import java.util.*;

public class ListTest {

    @Test
    public void setTest() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(1);
        Iterator<Integer> iterator = hashSet.iterator();
        for (Integer i : hashSet
        ) {
            System.out.println(i);
        }
    }

    @Test
    public void LinkedTest() {
        LinkedList<String> strings = new LinkedList<String>();
        strings.addFirst("a");
        strings.addFirst("b");
        strings.addLast("a");
        int b = strings.indexOf("b");
        System.out.println(b);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void vectorTest() {
        Vector<String> vector = new Vector<String>();
        vector.add("a");
        vector.add("b");
        vector.add("c");
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        for (int i = vector.size() - 1; i >= 0; i--) {
            System.out.println(vector.get(i));
        }
    }

    @Test
    public void vectorTestTwo() {
        Vector<Integer> vector = new Vector();


        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i); //往vector中添加元素
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //获取vector的大小
                    for (int i = 0; i < vector.size(); i++) {
                        //移除第i个数据
                        vector.remove(i);
                    }
                }
            });
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //获取vector的大小
                    for (int i = 0; i < vector.size(); i++) {
                        //获取第i个数据并打印
                        System.out.println(vector.get(i));
                    }
                }
            });
            removeThread.start();
            printThread.start();
            //避免同时产生过多线程
            while (Thread.activeCount() > 20) ;
        }

    }

    @Test
    public void stackTest(){
        Stack<String> strings = new Stack<>();
        strings.push("a");
        strings.push("a");
        strings.push("b");
        strings.push("c");
        strings.push("b");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        //boolean d = strings.add("d");
    }

    @Test
    public void hashMapTest(){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a","a");
        hashMap.put("b","b");
        hashMap.put("c","c");
        if (hashMap.get("a").equals("a")){
            System.out.println("duile");
        }
    }

    @Test
    public void hashSetTest(){
        HashSet<User> users = new HashSet<>();
        User user = new User();
        User user1 = new User();
        user.setId(1);
        user1.setId(1);
        users.add(user);
        users.add(user1);
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            System.out.println(next);
            //test
        }
    }
}
