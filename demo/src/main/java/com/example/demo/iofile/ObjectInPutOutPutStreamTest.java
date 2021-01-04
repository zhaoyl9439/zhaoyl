package com.example.demo.iofile;

import com.example.demo.async.Person;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ObjectInPutOutPutStreamTest {

    /**
     * 序列化
     */
    @Test
    public void testObjectOutputStream(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱花花"));
            oos.flush();

            oos.writeObject(new Cat(2, "大王"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 反序列化
     */
    @Test
    public void testOnjectInputStream() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            String data = (String) ois.readObject();
            Cat cat = (Cat) ois.readObject();

            System.out.println(data);
            System.out.println(cat);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
