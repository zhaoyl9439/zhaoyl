package com.example.demo.async;


import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class HungryEvent extends ApplicationEvent {

    public HungryEvent(Object o){
        super(o);
    }
}
