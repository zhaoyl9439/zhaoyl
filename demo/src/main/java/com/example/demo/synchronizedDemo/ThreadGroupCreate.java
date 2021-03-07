package com.example.demo.synchronizedDemo;

public class ThreadGroupCreate {

    public static void main(String[] args) {

       ThreadGroup tg1 = new ThreadGroup("TG1");
       Thread t1 = new Thread(tg1 , "t1") {
           @Override
           public void run() {
               while (true) {
                   try {
                       System.out.println(getThreadGroup().getName());
                       System.out.println(getThreadGroup().getParent());
                       System.out.println(getThreadGroup().getParent().activeCount());

                       Thread.sleep(10000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       };

       t1.start();

        ThreadGroup tg2 = new ThreadGroup("TG2");
        Thread t2 = new Thread(tg2 , "t2") {
            @Override
            public void run() {
                System.out.println(t1.getName());
            }
        };

        t2.start();

    }
}
