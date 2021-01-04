package com.example.demo.iofile;

import org.junit.jupiter.api.Test;

import java.io.*;

public class InputStreamReaderOutPutStreamWriter {

    @Test
    public void test() {

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new FileInputStream(new File("src/理赔码值.txt")), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream(new File("src/理赔码值1.txt")), "gbk");

            char[] chars = new char[1024];
            int len;
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
