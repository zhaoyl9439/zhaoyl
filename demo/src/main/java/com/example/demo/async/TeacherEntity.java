package com.example.demo.async;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static com.example.demo.async.Printer.print;

@Component
public class TeacherEntity {

    @Async
    // @EventListener(HungryEvent.class)
    public void cook(HungryEvent hungryEvent) throws InterruptedException {
        Person person = (Person) hungryEvent.getSource();
        print(person.getName() + "开始做饭~");
        Thread.sleep(3000);
        print("做好了~");
    }
}
