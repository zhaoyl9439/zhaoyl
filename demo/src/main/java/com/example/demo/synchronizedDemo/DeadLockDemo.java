package com.example.demo.synchronizedDemo;


/**
 * 开启了两个线程threadA, threadB,其中threadA占用了resource_a,
 * 并等待被threadB释放的resource _b。threadB占用了resource _b正在等待被threadA释放的resource _a。
 * 因此threadA,threadB出现线程安全的问题，形成死锁。
 */
public class DeadLockDemo {

    private static String resources_a = "A";
    private static String resources_b = "B";

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock(){
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resources_a) {
                    System.out.println("get resources_a");
                    try {
                        Thread.sleep(3000);
                        synchronized (resources_b) {
                            System.out.println("get resources_b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resources_b) {
                    System.out.println("get resources_b");
                    synchronized (resources_a) {
                        System.out.println("get resources_a");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
