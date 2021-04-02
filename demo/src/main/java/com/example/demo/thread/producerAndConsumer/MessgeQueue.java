package com.example.demo.thread.producerAndConsumer;

import java.util.LinkedList;

public class MessgeQueue {

    private final LinkedList<Message> queue;

    private static final int DEFAULT_MAX_LIMIT = 100;

    private final int limit;

    public MessgeQueue() {
        this(DEFAULT_MAX_LIMIT);
    }

    public MessgeQueue(final int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    public void put(Message message) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() > limit) {
                queue.wait();
            }

            queue.addLast(message);
            queue.notifyAll();
        }
    }

    public Message take() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }

            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

    public int getMaxLimit() {
        return  this.limit;
    }

    public int getMessageSise() {
        synchronized (queue) {
            return queue.size();
        }
    }

}
