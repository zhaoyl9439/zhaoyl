package com.example.demo.study.object;

public class FinalizeTest {

    public static void main(String[] args) {
        Persones p = new Persones("Peter", 99);
        System.out.println(p);
        p = null;//此时对象实体就是垃圾对象，等待呗回收。但时间不确定。
        System.gc();

    }
}

class Persones{

    private String name;
    private int age;

    public Persones(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("回收对象-->" + this);
    }

    @Override
    public String toString() {
        return "Persones{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
