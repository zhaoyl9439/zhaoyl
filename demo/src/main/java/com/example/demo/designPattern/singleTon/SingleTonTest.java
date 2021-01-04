package com.example.demo.designPattern.singleTon;

public class SingleTonTest {

    public static void main(String[] args) {
        Order1 order11 = Order1.getInstance();
        Order1 order12 = Order1.getInstance();
        System.out.println(order11 == order12);

        Order2 order21 = Order2.getInstance();
        Order2 order22 = Order2.getInstance();
        System.out.println(order21 == order22);

    }

}

// 饿汉式 线程安全的，加载时间过长
class Order1{

    private Order1() {

    }
    private static Order1 instance = new Order1();

    public static Order1 getInstance(){
        return instance;
    }
}

// 懒汉式 线程不安全 需要时再加载
class Order2{

    private Order2() {
    }

    private static Order2 instance = null;

    public static Order2 getInstance(){

        if (instance == null) {
            instance = new Order2();
        }
        return instance;
    }
}