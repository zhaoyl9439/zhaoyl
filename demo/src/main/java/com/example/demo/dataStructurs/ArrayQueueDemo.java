package com.example.demo.dataStructurs;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 查看队列头部数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    queue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("取出队列头部的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }
}

//使用数组模拟队列
class ArrayQueue{

    private int maxSize; //数组最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //存放数据，模拟队列

    //队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头，分析出front是指向队列头的前一个位置
        rear = -1; //指向队列尾，队列最后一个数据
    }
    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize-1;
    }
    //判断对队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据 进队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满~~~~");
            return;
        }
        rear++; //rear后移
        arr[rear] = n;
    }
    //获取队列的数据 出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空~~~~");
        }
        front++; //front后移
        return arr[front];
    }
    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列已空,没有数据~~~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\n", arr[i]);
        }
    }
    //显示队列头
    public int headQueue(){
        if (isEmpty()) {
            System.out.println("队列已空,没有数据~~~~");
        }
        return arr[front+1];
    }
}
