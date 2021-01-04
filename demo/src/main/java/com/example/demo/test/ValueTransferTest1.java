package com.example.demo.test;

/**
 * 方法的形参的传递机制，值传递
 *  值传递机制
 *      如果参数是基本数据类型，此时参数给形参的是实参真实存储的数据值
 *      如果参数是引用数据类型，此时参数赋给形参的是实参存储数据的地址值
 */
public class ValueTransferTest1 {

    public static void main(String[] args) {

        int m = 10;
        int n = 20;

        ValueTransferTest1 test = new ValueTransferTest1();
        test.swap(m, n);
        System.out.println("m = " + m + " n = " + n);

        Data data = new Data();
        data.m = 10;
        data.n = 20;

        test.swap(data);
        System.out.println("m = " + data.m + " n = " + data.n);
    }

    public void swap(int m, int n){
        int temp = m;
        m = n;
        n = temp;
    }

    public void swap(Data data){
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data{
    int m;
    int n;
}