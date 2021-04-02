package com.example.demo.thread;

public class VolatileTest {

    private volatile static int INT_VALUE = 0;

    private final static int MAX_VALUE = 5;

    public static void main(String[] args) {

        new Thread(()->{
            int loclValue = INT_VALUE;
            while (loclValue < MAX_VALUE) {
                if (loclValue != INT_VALUE) {
                    System.out.printf("The value update to [%d]\n", INT_VALUE);
                    loclValue = INT_VALUE;
                }
            }
        }, "READER").start();

        new Thread(()->{
            int loclValue = INT_VALUE;
            while (INT_VALUE < MAX_VALUE) {
                System.out.printf("UPDATE The value to [%d]\n", loclValue++);
                INT_VALUE = loclValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATE").start();
    }

}
