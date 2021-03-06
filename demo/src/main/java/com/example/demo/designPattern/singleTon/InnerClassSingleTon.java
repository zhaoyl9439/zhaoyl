package com.example.demo.designPattern.singleTon;

public class InnerClassSingleTon {

    public static SingleTon getInstance(){
        return SingleTon.singleTon;
    }

    private static class SingleTon{

        static SingleTon singleTon = new SingleTon();
    }


}
