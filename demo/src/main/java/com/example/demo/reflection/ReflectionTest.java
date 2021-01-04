package com.example.demo.reflection;

import com.example.demo.iofile.Cat;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test() throws Exception {

        Class clazz = Cat.class;
        // 通过反射创建对象
        Constructor cons = clazz.getConstructor(int.class, String.class);

        Cat cat = (Cat) cons.newInstance(2, "大王");
        System.out.println(cat.toString());

        // 通过反射调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(cat, 3);
        System.out.println(cat.toString());

        // 通过反射，调动方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(cat);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // 通过反射调用类的私有结构
        // 私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Cat cat1 = (Cat) cons1.newInstance("多多");
        System.out.println(cat1);
        // 私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(cat, "huahua");
        System.out.println(cat.toString());
        // 私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(cat, "中国");
        System.out.println("返回值：" + nation);
    }


    @Test
    public void test2() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性：.class
        Class clazz1 = Cat.class;
        System.out.println(clazz1);
        // 方式二：通过运行时类的对象，调用getClass()
        Cat cat = new Cat();
        Class clazz2 = cat.getClass();
        System.out.println(clazz2);
        // 方式三：调用clss的静态方法forName(String path)
        Class clazz3 = Class.forName("com.example.demo.iofile.Cat");
        System.out.println(clazz3);
        // 方法四：使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clzz4 = classLoader.loadClass("com.example.demo.iofile.Cat");
        System.out.println(clzz4);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clzz4);
    }
}
