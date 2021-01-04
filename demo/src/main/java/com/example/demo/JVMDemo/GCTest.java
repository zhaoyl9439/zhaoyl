package com.example.demo.JVMDemo;

import java.util.ArrayList;


/**
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 */
public class GCTest {

    public static void main(String[] args) {
        int i = 0;

        try {
            ArrayList<String> list = new ArrayList<>();
            String a = "com.example.demo.JVMDemo.GCTest";
            while (true){
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable t){
            t.printStackTrace();
            System.out.println("遍历次数：" + i);
        }

    }

}
