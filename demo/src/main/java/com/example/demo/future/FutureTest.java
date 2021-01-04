package com.example.demo.future;

import java.util.concurrent.*;

// 异步调用
public class FutureTest {

    public static void main(String[] args) {
       try {
            testFutureTask1();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        try {
            FutureTask<Integer> futureTask = testFutureTask2();
            System.out.println("主线程进行中~~~");
            System.out.println("task运行结果：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void testFutureTask1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executorService.submit(futureTask);
        executorService.shutdown();

        Thread.sleep(1000);
        System.out.println("主线程进行中~~~");

        System.out.println("task运行结果：" + futureTask.get());

        System.out.println("所有任务执行完毕！");
    }

    public static FutureTask<Integer> testFutureTask2(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("子线程开始~~~");
                Thread.sleep(3000);
                System.out.println("子线程结束~~~");
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum+=i;
                }
                return sum;
            }
        });
        executorService.execute(futureTask);
        executorService.shutdown();

        return futureTask;
    }
}

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

        System.out.println("子线程开始~~~");
        Thread.sleep(3000);
        System.out.println("子线程结束~~~");
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;

    }
}
