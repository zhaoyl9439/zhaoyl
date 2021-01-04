package com.example.demo.designPattern.factory;

interface AbstractFactory{
    Phone makePhone();
    PC makePC();
}

class XiaoMiFactory implements AbstractFactory{

    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public PC makePC() {
        return new MiPC();
    }
}

class AppleFactoey implements AbstractFactory{

    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public PC makePC() {
        return new IpPC();
    }
}

// 工厂方法模式
public class AbxtractFactory {

    public static void main(String[] args) {
        AbstractFactory xiaoMiFactory = new XiaoMiFactory();
        AbstractFactory appleFactoey = new AppleFactoey();
        xiaoMiFactory.makePhone();
        xiaoMiFactory.makePC();
        appleFactoey.makePhone();
        appleFactoey.makePC();
    }
}
