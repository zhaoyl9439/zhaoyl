package com.example.demo.iofile;

import cn.hutool.core.text.csv.CsvUtil;

import java.io.Serializable;

public class Cat implements Serializable {
    private static final long serialVersionUID = 1L; //serialVersionUID 标识不同版本

    public int age;

    private String name;


    public Cat() {
    }

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void show() {
        System.out.println("我是大王~");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
