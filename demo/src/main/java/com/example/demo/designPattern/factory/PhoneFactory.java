package com.example.demo.designPattern.factory;

interface Phone {
    void makePhone();
}

interface PC {
    void makePC();
}

class MiPC implements PC{

    public MiPC() {
        this.makePC();
    }

    @Override
    public void makePC() {
        System.out.println("MIPC");
    }
}

class IpPC implements PC{

    public IpPC() {
        this.makePC();
    }

    @Override
    public void makePC() {
        System.out.println("IpPC");
    }
}

class IPhone implements Phone {

    public IPhone() {
        this.makePhone();
    }

    @Override
    public void makePhone() {
        System.out.println("IPhone~~~");
    }
}

class MiPhone implements Phone{

    public MiPhone() {
        this.makePhone();
    }

    @Override
    public void makePhone() {
        System.out.println("MiPhone~~~");
    }
}

// 简单工厂模式
public class PhoneFactory {
    public Phone makePhone(String phoneName) {
        if (phoneName.equalsIgnoreCase("IPhone")) {
            return new IPhone();
        }
        if (phoneName.equalsIgnoreCase("MiPhone")) {
            return new MiPhone();
        }
        return null;
    }

    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        IPhone iPhone = (IPhone) phoneFactory.makePhone("IPhone");
    }

}