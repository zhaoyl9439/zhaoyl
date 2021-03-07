package com.example.demo.thread;

import java.util.Optional;
import java.util.stream.IntStream;

public class WaitSet {

    private static final Object LOCK = new Object();

    /**
     * 1.所有的对象都会有一个wait set，用来存放调用了该对象wait方法之后进入block状态线程
     * 2.线程被notify之后，不一定立即得到执行
     * 3.线程从wait set中被唤醒顺序不一定是FIFO（顺序）
     * 4.线程被唤醒后，必须重新获取锁
     * @param args
     */
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            try {
                                Optional.of(Thread.currentThread().getName() + " will come to wait set ").ifPresent(System.out::println);
                                LOCK.wait();
                                Optional.of(Thread.currentThread().getName() + " will leave to wait set ").ifPresent(System.out::println);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );

        IntStream.rangeClosed(1, 10).forEach(i->{
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
