package com.rlws.maopao.test;

import java.util.List;

public abstract class ChouXiangLei {



    private void eat(){
        System.out.println("吃");
    };

    protected void good(){
        System.out.println("hao");
    }

    public void call(){
        System.out.println("叫");
    }

    public List maoPao(List<Integer> list){
        for (int i = 0 ; i < list.size()-1 ; i ++)
            for (int j =i ; j < list.size() ; j ++)
                if (list.get(i) > list.get(j)){
                    int temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
        return list;
    }

}
