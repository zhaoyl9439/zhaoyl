package com.example.demo.JVMDemo;


/**
 * 掩饰栈中异常
 */
public class StackErrorTest {

    /**
     * 如果采用固定大小的虚拟机，每一个线程的Java虚拟机栈容量可以在线程创建的时候独立选定。
     * 如果线程请求分配的栈容量超过Java虚拟机栈允许的最大容量，Java虚拟机将会抛出一个StackOverflowError异常
     * java.lang.StackOverflowError
     *
     * 默认情况下 count : 11420 
     * 设置栈大小： -Xss256k : count : 2465
     *
     * 如果虚拟机可以动态扩展，并且在尝试扩展的时候无法申请到足够的内存，或者在创建线程的时候没有足够的内存去创建对应的虚拟机栈，
     * java虚拟机将会抛出一个OutOfMemoryError异常
     * @param args
     */
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }

}
