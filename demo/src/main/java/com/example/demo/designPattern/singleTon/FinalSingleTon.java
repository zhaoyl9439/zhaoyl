package com.example.demo.designPattern.singleTon;


import java.util.stream.IntStream;

// 一个类的静态属性只会在第一次加载类时初始化
public class FinalSingleTon {

    private FinalSingleTon() {
    }

    public static FinalSingleTon getInstance() {

        return SingleTonInstance.instance;
    }

    private static class SingleTonInstance{

        private static final FinalSingleTon instance = new FinalSingleTon();
    }

}

class FinalEnumSingleTon{

    private FinalEnumSingleTon() {

    }

    private enum Singleton {
        INSTANCE;

        private final  FinalEnumSingleTon instance;

        Singleton() {
            instance = new FinalEnumSingleTon();
        }

        public FinalEnumSingleTon getInstance() {
            return instance;
        }
    }

    public static FinalEnumSingleTon getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 100)
                .forEach(i->new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        System.out.println(FinalEnumSingleTon.getInstance());
                    }
                }.start());

    }

}