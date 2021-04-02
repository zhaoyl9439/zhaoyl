package com.example.demo.thread.threadLocal.context;

public class QueryFromDBAction {

    public void execute() {
        try {
            Thread.sleep(1000);
            ActionContext.getInstance().getContext().setName(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
