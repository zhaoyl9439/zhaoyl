package com.example.demo.async;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import static com.example.demo.async.Printer.print;

@Component
public class Person implements ApplicationEventPublisherAware {

    private int hungry;
    private String name = "admin";

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work(){
        if (hungry < 10) {
            applicationEventPublisher.publishEvent(new HungryEvent(this));
            print("饿了，谁来帮我做做饭..");
        }
        print("继续工作....");
    }

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
