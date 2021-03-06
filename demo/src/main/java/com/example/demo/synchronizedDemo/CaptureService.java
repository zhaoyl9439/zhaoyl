package com.example.demo.synchronizedDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

/**
 * 控制线程数
 */
public class CaptureService {

    private static final LinkedList<Control> CONTROLS = new LinkedList<>();

    private static final int MAX_WORKERS = 5;

    public static void main(String[] args) {

        ArrayList<Thread> workers = new ArrayList<>();
        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10").stream()
                .map(CaptureService::createCaptureThread)
                .forEach(t -> {
                    t.start();
                    workers.add(t);
                });
        workers.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("Finished").ifPresent(System.out::println);
    }


    private static Thread createCaptureThread(String name) {

        return new Thread(() -> {
            Optional.of("The Worker [" + Thread.currentThread().getName() + "] BEG").ifPresent(System.out::println);
            synchronized (CONTROLS) {
                while (CONTROLS.size() > MAX_WORKERS) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                CONTROLS.addLast(new Control());
            }

            Optional.of("Worker [" + Thread.currentThread().getName() +"] is working···").ifPresent(System.out::println);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (CONTROLS) {
                Optional.of("The Worker [" + Thread.currentThread().getName() + "] END").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }

        }, name);
    }

    private static class Control{

    }
}
