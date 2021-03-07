package com.example.demo.synchronizedDemo;

import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreadPoolSimple {

    private final int size;

    private final int queueSize;

    private static final int DEFAULT_SIZE = 10;

    private static final int DEFAULT_SIZE_QUEUE_SIZE = 1000;

    private static volatile int seq = 0;

    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POLL-";

    private static final ThreadGroup GROUP = new ThreadGroup("Poll_Group");

    private static final LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private static final List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    private final DiscardPolicy discardPolicy;

    public static final DiscardPolicy DEFAULT_DISCARD_POLISY = () -> {
        throw new DiscardException("Discard this task");
    };

    public ThreadPoolSimple() {
        this(DEFAULT_SIZE, DEFAULT_SIZE_QUEUE_SIZE, DEFAULT_DISCARD_POLISY);
    }

    private volatile boolean destroy = Boolean.FALSE;

    public ThreadPoolSimple(int size, int queueSize, DiscardPolicy discardPolicy) {
        this.size = size;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    public void submit(Runnable runnable) {
        if (destroy)
            throw new IllegalArgumentException("The thread poll already destry and not allow submit task");
        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > queueSize)
                discardPolicy.discard();
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private void createWorkTask() {
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()) {
            Thread.sleep(50);
        }

        int initVal = THREAD_QUEUE.size();
        while (initVal > 0) {
            for (WorkerTask task : THREAD_QUEUE) {
                if (task.getTaskStake() == TaskState.BLOCKED) {
                    task.interrupt();
                    task.close();
                    initVal--;
                } else {
                    Thread.sleep(10);
                }
            }
        }
        this.destroy = Boolean.TRUE;
        System.out.println("The thread Poll disposed");
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean destroy() {
        return destroy;
    }

    private enum TaskState {
        FREE, RUNNUNG, BLOCKED, DEAD;
    }

    public static class DiscardException extends RuntimeException{
        public DiscardException(String message) {
            super(message);
        }
    }

    /**
     * 拒绝策略
     */
    public interface DiscardPolicy{
        void discard() throws DiscardException;
    }

    private static class WorkerTask extends Thread{

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskStake() {
            return this.taskState;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                    if (runnable != null) {
                        taskState = TaskState.RUNNUNG;
                        runnable.run();
                        taskState = TaskState.FREE;
                    }
                }
            }
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) {
        ThreadPoolSimple threadPool = new ThreadPoolSimple(6, 10, ThreadPoolSimple.DEFAULT_DISCARD_POLISY);
        for (int i = 0; i < 40; i++) {
            threadPool.submit(() -> {
                System.out.println("The Runnable be serverd by " + Thread.currentThread() + " start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The Runnable be serverd by " + Thread.currentThread() + " finished");
            });
        }
        try {
            Thread.sleep(1000);
            threadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
