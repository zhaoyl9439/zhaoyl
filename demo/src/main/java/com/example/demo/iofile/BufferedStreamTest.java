package com.example.demo.iofile;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 缓存流，内部提供了一个缓存区
 * 提高读写速度
 */
public class BufferedStreamTest {

    @Test
    public void test1(){

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File getfile = new File("src/照片.jpg");
            File outfile = new File("src/照片1.jpg");

            FileInputStream fileInputStream = new FileInputStream(getfile);
            FileOutputStream fileOutputStream = new FileOutputStream(outfile);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int len;

            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            // 先关闭外层的流，再关闭里层的流
            try {
                if (bufferedInputStream != null)
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null)
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文本文件复制
     */
    @Test
    public void testBufferReadBuferWriter() {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            // 创建响应的流
            bufferedReader = new BufferedReader(new FileReader(new File("src/理赔码值.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("src/理赔码值1.txt")));

            // 读写操作
            // 方式一:
            /*char[] chars = new char[1024];
            int len;
            while ((len = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, len);
            }*/
            // 方式二:
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                // 方法一:
                //bufferedWriter.write(data + "\n"); // 不包含换行

                // 方法二:
                bufferedWriter.write(data); // 不包含换行
                bufferedWriter.newLine(); //换行
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
