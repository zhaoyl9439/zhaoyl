package com.example.demo.reflection;


@MyAnnotation(value = "hi")
public class Peron extends Creature<String> implements Comparable<String>, MyInterface {

    public int age;
    private String name;

    public Peron() {
    }

    @MyAnnotation(value = "abc")
    public Peron(String name) {
        this.name = name;
    }

    Peron(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("国籍是：" + nation);
        return nation;
    }

    public String display(String interests){
        return interests;
    }

    @Override
    public void info() {
        System.out.println("人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("静态方法");
    }

    @Override
    public String toString() {
        return "Peron{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
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
