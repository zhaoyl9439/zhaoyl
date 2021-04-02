package com.example.demo.thread.threadLocal.context;

public class QueryFromHttpAction {

    public void execute() {
        Context context = ActionContext.getInstance().getContext();
        String name = context.getName();
        String cardId = getCardId(name);
        context.setCardId(cardId);
    }

    private String getCardId(String name) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return String.valueOf(name + " " + Thread.currentThread().getId());
    }
}
