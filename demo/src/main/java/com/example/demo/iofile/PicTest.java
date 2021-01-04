package com.example.demo.iofile;

import org.junit.jupiter.api.Test;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {

    // 图片加密、解密
    @Test
    public void test(){

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(new File("src/照片secret.jpg"));
            outputStream = new FileOutputStream(new File("src/照片2.jpg"));

            byte[] bytes = new byte[20];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {

                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
