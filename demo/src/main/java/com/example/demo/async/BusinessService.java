package com.example.demo.async;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BusinessService {

    @Async
    public void doBusiness() throws InterruptedException {
        System.out.println("子任务开始~~~");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("子任务结束~~~");
    }

}

class TestBusiness{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        BusinessService businessService = context.getBean("businessService", BusinessService.class);
        try {
            businessService.doBusiness();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主任务");
    }
}

