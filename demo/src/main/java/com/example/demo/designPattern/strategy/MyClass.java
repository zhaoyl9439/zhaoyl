package com.example.demo.designPattern.strategy;

public class MyClass {

    public void myMethod(MyInterfce myInterfce){
        System.out.println("方法中的代码");
        myInterfce.insertCode();
        System.out.println("方法中的代码");

    }
}

interface MyInterfce{

    public void insertCode();

}

class InsertCode1 implements MyInterfce{
    @Override
    public void insertCode() {
        System.out.println("111~");
    }
}

class InsertCode2 implements MyInterfce{
    @Override
    public void insertCode() {
        System.out.println("222~");
    }
}
