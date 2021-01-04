package com.example.demo.iofile;


import org.junit.jupiter.api.Test;

import java.io.*;

//字符流
public class FileReaderWriter {

    /**
     * 读入
     */
    @Test
    public void test1(){

        FileReader fileReader = null;

        // 1.File类的实例化
        File file = new File("src/hello.txt");

        try {
            // 2.FileReader流的实例化
            fileReader = new FileReader(file);

            char[] chars = new char[5];
            int len;

            // 3.流的读入
            while ((len = fileReader.read(chars)) != -1) {
                //for (int i = 0; i < len; i++) {
                //    System.out.print(chars[i]);
                //}
                String s = new String(chars, 0, len);
                System.out.print(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭资源
                if (file != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写出
     */
    @Test
    public void test2() throws IOException {

        // 1.提供file类的对象
        File file = new File("src/money.txt");

        // 2.提供FileWriter的对象
        FileWriter fileWriter = new FileWriter(file, true); // true:追加

        // 3.写出
        fileWriter.write("money");

        // 4.关闭资源
        fileWriter.close();
    }

    /**
     * 复制
     */
    @Test
    public void test3() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            // 1.创建File类的对象
            File getfile = new File("src/money.txt");
            File outfile = new File("src/money1.txt");

            // 2.创建输入流、输出流
            fileReader = new FileReader(getfile);
            fileWriter = new FileWriter(outfile);

            // 3.数据的读入和输出
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭资源
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }











}
