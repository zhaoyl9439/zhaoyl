package com.example.demo.thread.threadLocal;

public class ThreadLocalSimpleTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "大王";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        //threadLocal.set("花花");
        Thread.sleep(1000);
        String value = threadLocal.get();
        System.out.println(value);
    }

}
