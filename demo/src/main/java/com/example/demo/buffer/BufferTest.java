package com.example.demo.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 直接缓冲区与非直接缓冲区
 *  非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中
 *  直接缓冲区：通过allocate()方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class BufferTest {

    @Test
    public void test3(){
        ByteBuffer bf = ByteBuffer.allocateDirect(1026); //直接缓冲区
        System.out.println(bf.isDirect());
    }

    @Test
    public void test2(){

    }
}
