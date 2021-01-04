package com.example.demo.iofile;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputOutPutTest {

    @Test
    public void test1() {
        FileInputStream inputStream = null;
        try {
            File file = new File("src/hello.txt");

            inputStream = new FileInputStream(file);

            byte[] bytes = new byte[4];
            int len;

            while ((len = inputStream.read(bytes)) != -1){
                String s = new String(bytes, 0, len);
                System.out.print(s);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
