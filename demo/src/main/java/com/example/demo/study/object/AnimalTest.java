package com.example.demo.study.object;

public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();

        test.func(new Dog());
        test.func(new Cat());
    }

    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }

}

class Animal{

    public void eat(){
        System.out.println("动物：进食");
    }

    public void shout(){
        System.out.println("动物：叫");
    }

}

class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("啃骨头");
    }

    @Override
    public void shout() {
        System.out.println("汪汪~");
    }


}

class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }

    @Override
    public void shout() {
        System.out.println("喵喵~");
    }
}