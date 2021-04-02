package com.example.demo.thread.producerAndConsumer;

public class ProducerAndConsumerClient {

    public static void main(String[] args) {
        final MessgeQueue messgeQueue = new MessgeQueue();

        new ProducerThread(messgeQueue, 1).start();
        new ConsumerThread(messgeQueue, 1).start();

    }
}
