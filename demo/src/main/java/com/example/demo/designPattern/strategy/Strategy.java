package com.example.demo.designPattern.strategy;


// 策略模式

public interface Strategy {

    void method();

}

class Contex {

    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void method(){
        strategy.method();
    }

}

class ConcreteStrategyMethodA implements Strategy{

    @Override
    public void method() {
        System.out.println("策略A~~~");
    }

}

class ConcreteStrategyMethodB implements Strategy{

    @Override
    public void method() {
        System.out.println("策略B~~~");
    }

}

class ConcreteStrategyMethodC implements Strategy{

    @Override
    public void method() {
        System.out.println("策略C~~~");
    }

}

class Client {

    public static void main(String[] args) {
        /*MyClass myClass = new MyClass();
        myClass.myMethod(new InsertCode1());

        myClass.myMethod(new InsertCode2());*/

        Contex contex = new Contex();
        contex.setStrategy(new ConcreteStrategyMethodA());
        contex.method();

        contex.setStrategy(new ConcreteStrategyMethodB());
        contex.method();

        contex.setStrategy(new ConcreteStrategyMethodC());
        contex.method();
    }

}