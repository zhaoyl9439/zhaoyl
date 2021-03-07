package com.example.demo.thread;

import java.util.Arrays;
import java.util.Optional;

/**
 * 异常
 */
public class ThreadException {

    private static final  int A = 10;

    private static final  int B = 0;

    public static void main(String[] args) {

        Thread t = new Thread(()-> {
            try {
                Thread.sleep(5_000L);
                int result = A / B;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println(e);
            System.out.println(thread);
        });
        t.start();
    }

}


class TestCallMain{

    public static void main(String[] args) {
        new TestCall2().test();
    }

}

/**
 * 查看调用路径
 */
class TestCall2 {

    public void test(){
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + ":" + e.getMethodName() +":" + e.getLineNumber())
                        .ifPresent(System.out::println)
                        );
    }

}

class TestCall1{

    private TestCall2 testCall2 = new TestCall2();

    public void test(){
        testCall2.test();
    }

}
