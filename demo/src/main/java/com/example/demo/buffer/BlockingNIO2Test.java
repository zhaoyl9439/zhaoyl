package com.example.demo.buffer;


import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockingNIO2Test{

    // 客户端
    @Test
    public void client() throws IOException {

        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("src/money.txt"), StandardOpenOption.READ);

        // 分配指定缓冲区的大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取本地文件，并发送到服务器
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        socketChannel.shutdownInput();

        // 接收服务端的反馈
        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }

        inChannel.close();
        socketChannel.close();

    }

    // 服务端
    @Test
    public void server() throws IOException {

        // 获取通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("src/money3.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // 绑定连接
        socketChannel.bind(new InetSocketAddress(9898));

        // 获取客户端连接的通道
        SocketChannel schannel = socketChannel.accept();

        // 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 接收客户端的数据并保存在本地
        while (schannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        // 发送反馈给客户端
        byteBuffer.put("接受数据成".getBytes());
        byteBuffer.flip();
        schannel.write(byteBuffer);

        // 关闭通道
        schannel.close();
        outChannel.close();
        socketChannel.close();

    }

}
