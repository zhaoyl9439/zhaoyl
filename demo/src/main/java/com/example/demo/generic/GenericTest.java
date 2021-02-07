package com.example.demo.generic;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GenericTest {

    @Test
    public void tes1(){

        Order order = new Order();
        order.setOrderId(13);
        order.setOrderName("name");
        System.out.println(order);

        Order<String> order1 = new Order<String>("name",123, "order:AA");
        order1.setOrderT("AA:order1");
    }

    @Test
    public void test2(){
        SubOrder1 order1 = new SubOrder1();
        order1.setOrderT(123);

        SubOrder<String > subOrder = new SubOrder<>();
        subOrder.setOrderT("124");
    }

    @Test
    public <T> void test3(){

        T[] arr = (T[])new Object[10];

    }


    @Test
    public void test4(){

        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.arrayToList(arr);

        System.out.println(list);


    }

}

