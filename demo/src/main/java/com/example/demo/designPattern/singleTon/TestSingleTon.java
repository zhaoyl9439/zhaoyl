package com.example.demo.designPattern.singleTon;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleTon {
    boolean lock;

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException {
        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String >());
        final TestSingleTon lock = new TestSingleTon();

        lock.setLock(true);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (!lock.isLock()) {
                            SingleTon singleTon = SingleTon.getInstance();
                            instanceSet.add(singleTon.toString());
                            break;
                        }
                    }
                }
            });
        }
        //Thread.sleep(5000);
        lock.setLock(false);
        //Thread.sleep(5000);
        System.out.println("获取实例~~~");
        int i = 0;
        for (String instance: instanceSet) {
            System.out.println(i++);
            System.out.println(instance);
        }
        executorService.shutdown();
    }
}

// 懒汉式 线程不安全
class SingleTon {

    private static SingleTon singleTon;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            singleTon = new SingleTon();
        }
        return singleTon;
    }

}


// 懒汉式
class BadSynchronizedSingleTon {

    private static BadSynchronizedSingleTon badSynchronizedSingleTon;

    private BadSynchronizedSingleTon() {
    }

    public synchronized static BadSynchronizedSingleTon getInstance() {
        if (badSynchronizedSingleTon == null) {
            badSynchronizedSingleTon = new BadSynchronizedSingleTon();
        }
        return badSynchronizedSingleTon;
    }

}

// 饿汉式 双重加锁
class SynchronizedSingleton{

    private static SynchronizedSingleton synchronizedSingleton;

    public SynchronizedSingleton() {
    }

    public static SynchronizedSingleton getInstance() {
        if (synchronizedSingleton == null) {
            synchronized (SynchronizedSingleton.class) {
                if (synchronizedSingleton == null) {
                    synchronizedSingleton = new SynchronizedSingleton();
                }
            }
        }

        return synchronizedSingleton;
    }
}

