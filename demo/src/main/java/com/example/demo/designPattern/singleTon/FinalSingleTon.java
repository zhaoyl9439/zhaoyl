package com.example.demo.designPattern.singleTon;


// 一个类的静态属性只会在第一次加载类时初始化
public class FinalSingleTon {

    private FinalSingleTon() {
    }

    public static FinalSingleTon getInstance() {
        return SingleTonInstance.instance;
    }

    private static class SingleTonInstance{

        static FinalSingleTon instance = new FinalSingleTon();
    }

}
