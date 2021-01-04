package com.example.demo.generic;

import java.util.ArrayList;
import java.util.List;

public class SubOrder<T> extends Order<T>{

    public <E> List<E> arrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
