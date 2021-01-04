package com.example.demo.study.object;

public class InstanceTest {

    public static void main(String[] args) {
        InstanceTest test = new InstanceTest();
        test.method(new Student());
    }

    public void method(Persons persons){
        String info = persons.getInfo();
        System.out.println(info);

        if (persons instanceof Graduate){
            System.out.println("a graduated student");
            System.out.println("a student");
            System.out.println("a persons");
        } else if (persons instanceof Student){
            System.out.println("a student");
            System.out.println("a persons");
        } else {
            System.out.println("a persons");
        }
    }
}

class Persons {

    protected String name = "person";
    protected int age = 50;

    public String getInfo(){
        return "Name:" + name + "\nage:" + age;
    }
}

class Student extends Persons{

    protected String school = "school";

    @Override
    public String getInfo() {
        return "Name:" + name + "\nage:" + age + "\nschool:" + school;

    }
}

class Graduate extends Student{
    public String maior = "IT";

    @Override
    public String getInfo() {
        return "Name:" + name + "\nage:" + age + "\nschool:" + school + "\nmajor" + maior;

    }
}

