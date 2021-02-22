package com.example.demo.buffer;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BioServer {


    @Test
    public void server() throws IOException {

        byte[] bs = new byte[1024];
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9898));

        while (true){
            System.out.println("等待连接~~~");
            // accept 专门负责通信
            Socket socket = serverSocket.accept(); // 阻塞--程序释放CPU资源
            System.out.println("连接成功~~~");
            /*System.out.println("start data~~~");
            int read = socket.getInputStream().read(bs);//阻塞
            System.out.println("end data~~~" + read);
            System.out.println(new String(bs));*/

            Thread thread = new Thread(new ExecuteSocket(socket));
            thread.start();
        }

    }


    @Test
    public void client() throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 9898));

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容：");
        while (true) {
            String next = scanner.next();
            socket.getOutputStream().write(next.getBytes(StandardCharsets.UTF_8));

        }
    }
}

class ExecuteSocket implements Runnable{

   byte[] bs = new byte[1024];
    Socket socket;

    public ExecuteSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            socket.getInputStream().read(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(bs));
    }
}