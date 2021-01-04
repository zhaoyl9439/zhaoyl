package com.example.demo.test;


/**
 * 变量的赋值
 * 如果变量是基本数据类型，此时赋值的是变量所保存的数据值
 * 如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值
 */
public class ValueTransforTest0 {

    public static void main(String[] args) {
        int m = 10;
        int n= m;

        System.out.println("m = " + m + " n = " + n);

        Order o1 = new Order();
        o1.orderId = 1001;
        Order o2 = o1; //赋值实体以后，o1和o2的地址相同，都指向了堆空间中的同一个
        System.out.println("o1 = " + o1.orderId + ";\to2 = " + o2.orderId);
        o2.orderId = 1002;
        System.out.println("o1 = " + o1.orderId + ";\to2 = " + o2.orderId);


    }

}

class Order{

    int orderId;

}
