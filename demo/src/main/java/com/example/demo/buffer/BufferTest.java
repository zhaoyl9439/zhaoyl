package com.example.demo.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;


public class BufferTest {

    @Test
    public void test3(){
        ByteBuffer bf = ByteBuffer.allocateDirect(1026); //直接缓冲区
        System.out.println(bf.isDirect());
    }

    /**
     * 两个核心方法
     * put（）
     * get（）
     * 通过allocate(int capacity)获取缓冲区
     * 四个核心属性
     * capacity：容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
     * limit：界限，表示缓冲区中可操作数据的大小。（limit后数据不能进行读写）
     * position：位置，表示缓冲区中正在操作数据的位置。
     * mark：标记，记录position的位置，可通过rese()恢复到mark的位置
     *
     * 0 <= mark <= position <=limit <= capacity
     */

    @Test
    public void test2(){

        ByteBuffer bf = ByteBuffer.allocate(1024);

        String str = "abcde";
        bf.put(str.getBytes());

        bf.flip();

        byte[] bytes = new byte[bf.limit()];
        bf.get(bytes, 0, 2);

        System.out.println(new String(bytes, 0 , 2));
        System.out.println(bf.position());

        bf.mark();

        bf.get(bytes, 2, 2);
        System.out.println(new String(bytes, 2, 3));
        System.out.println(bf.position());

        bf.reset();
        System.out.println(bf.position());

        //判断是否有剩余数据
        if (bf.hasRemaining()) {
            //获取可操作数据
            System.out.println(bf.remaining());
        }
    }

    @Test
    public void test1(){
        //1.分配一个指定大小的缓冲区
        ByteBuffer bf = ByteBuffer.allocate(1024);

        System.out.println("~~~~~~~~~~~~~~~~~allocate()~~~~~~~~~~~~~~~~~");
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());

        //2.存入数据
        System.out.println("~~~~~~~~~~~~~~~~~put()~~~~~~~~~~~~~~~~~");
        String s = "abcde";
        bf.put(s.getBytes());

        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());

        //3.切换读取数据模式
        System.out.println("~~~~~~~~~~~~~~~~~flip()~~~~~~~~~~~~~~~~~");
        bf.flip();
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());

        //4.读取缓冲区中数据
        System.out.println("~~~~~~~~~~~~~~~~~get()~~~~~~~~~~~~~~~~~");
        byte[] bytes = new byte[bf.limit()];
        bf.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());

        //5.可重复读取取数据
        System.out.println("~~~~~~~~~~~~~~~~~rewind()~~~~~~~~~~~~~~~~~");
        bf.rewind();
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());

        //6.清空缓冲区,缓冲区中数据依据存在，处于“被遗忘”状态
        System.out.println("~~~~~~~~~~~~~~~~~clear()~~~~~~~~~~~~~~~~~");
        bf.clear();
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());

        System.out.println((char) bf.get());
    }

}
