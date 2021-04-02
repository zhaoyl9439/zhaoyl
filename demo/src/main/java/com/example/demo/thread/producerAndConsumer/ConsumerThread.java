package com.example.demo.thread.producerAndConsumer;

import java.util.Random;

public class ConsumerThread extends Thread{

    private final MessgeQueue messgeQueue;

    private static final Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessgeQueue messgeQueue, int seq) {
        super("Consumer-" + seq);
        this.messgeQueue = messgeQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messgeQueue.take();
                System.out.println(Thread.currentThread().getName() + " take message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
