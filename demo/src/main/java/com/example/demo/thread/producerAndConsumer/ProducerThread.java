package com.example.demo.thread.producerAndConsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread extends Thread{

    private final MessgeQueue messgeQueue;

    private static final Random random = new Random(System.currentTimeMillis());

    private static final AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessgeQueue messgeQueue, int seq) {
        super("PRODUCER-" + seq);
        this.messgeQueue = messgeQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("Meaage-" + counter.getAndIncrement());
                messgeQueue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
