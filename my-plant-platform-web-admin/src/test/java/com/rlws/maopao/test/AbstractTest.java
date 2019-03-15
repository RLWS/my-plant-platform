package com.rlws.maopao.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractTest extends ChouXiangLei {

    @Test
    public void testDemo() {
        call();
        good();
        System.out.println("niaho");
        ArrayList<Integer> integers = new ArrayList<>(15);
        integers.add(5);
        integers.add(15);
        integers.add(55);
        integers.add(35);
        integers.add(95);
        integers.add(75);
        List list = maoPao(integers);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
