package com.example.demo.thread.threadLocal.context;

public class ExecutionTask implements Runnable{

    private QueryFromDBAction queryAction = new QueryFromDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        final Context context = ActionContext.getInstance().getContext();
        queryAction.execute();
        System.out.println("queryAction~");
        httpAction.execute();
        System.out.println("httpAction~");
        System.out.println("name= " + context.getName() + " cardId= " + context.getCardId());
    }
}
