package com.example.demo.study.object;

public class InterviewTest {

    public static void main(String[] args) {
        Base1 base = new Sub1();
        base.add(1, 2, 3);// sub_1

        Sub1 sub1 = (Sub1) base;
        sub1.add(1, 2, 3);// sub_2

        Base1 base1 = new Base1();
        System.out.println(base1.getClass().getSuperclass()); //Object

    }
}

class Base1{

    public void add(int a, int... arr){

        System.out.println("base1");
    }
}

class Sub1 extends Base1{

    public void add(int a, int[] arr) {
        System.out.println("sub_1");
    }
    public void add(int a, int b, int c){
        System.out.println("sub_2");
    }
}
