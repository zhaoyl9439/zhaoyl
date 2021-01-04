package com.example.demo.study.object;

import java.util.Date;

public class ObjectTest {
}

/**
 *  一。==和equals（）区别
 *      ==：运算符
 *      1. 可以使用在基本数据类型变量和引用数据类型变量中
 *      2. 如果比较的是基本数据类型：比较的是两个变量保存的数据是否相等。（类型不一定相同）
 *         如果比较的是引用数据类型的变量：比较两个对象的地址值是否相同（即两个引用指向的是否是一个对象实体）
 *      equal():
 *      1. 方法而非运算符
 *      2. 只能那适用于引用数据类型
 *      3. Object类中的equals()的定义：
 *      public boolean equals(Object obj) {
 *         return (this == obj);
 *      }
 *      说明：Object类中定义的equals()和==的作用是相同的，比较的都是两个引用是否指向同一个对象实体
 *      4.String、Date、File、包装类等都重写了equals()方法。重写以后，比较的不是两个对象的引用的地址是否相同，比较的是两个对象的”实体内容“是否相同
 */
class EqualsTest{

    public static void main(String[] args) {

        int i = 10;
        int j = 10;
        double d = 10.0;

        System.out.println(i == j); //true
        System.out.println(j == d); //true

        char c = 10;
        System.out.println(i == c); //true

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2); //true

        Customer customer1 = new Customer("zhaoyl", 18);
        Customer customer2 = new Customer("zhaoyl", 18);
        System.out.println(customer1 == customer2); //false
        System.out.println(customer1.equals(customer2)); //false

        String str1 = new String("大王");
        String str2 = new String("大王");
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str2)); //true

        String s1 = "花花";
        String s2 = "花花";
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); //true

        Date date1 = new Date(234536465765645L);
        Date date2 = new Date(234536465765645L);
        System.out.println(date1.equals(date2)); //true
    }

}

class Customer{
    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
