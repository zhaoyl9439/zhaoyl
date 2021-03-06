package com.example.demo.synchronizedDemo;

import java.util.stream.Stream;

/**
 * 生产者消费者 存在线程阻塞 问题
 */
public class RroduceConsumer {

    private int i = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    public void produce(){
        synchronized (LOCK) {
            while (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            LOCK.notifyAll();
            isProduced = true;
        }
    }

    public void consumer() {
        synchronized (LOCK) {
            while (!isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
            LOCK.notifyAll();
            isProduced = false;

        }
    }

    public static void main(String[] args) {
        RroduceConsumer pc = new RroduceConsumer();
        Stream.of("P1", "P2").forEach(n->
            new Thread("P") {
                @Override
                public void run() {
                    while (true)
                        pc.produce();
                }
            }.start()
        );
        Stream.of("C1", "C2").forEach(n->
            new Thread("C") {
                @Override
                public void run() {
                    while (true)
                        pc.consumer();
                }
            }.start()
        );
    }

}
