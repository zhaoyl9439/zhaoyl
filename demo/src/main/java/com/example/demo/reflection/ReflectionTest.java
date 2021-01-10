package com.example.demo.reflection;

import com.example.demo.iofile.Cat;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

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

    /**
     * 获取当前运行时类的属性结构
     */
    @Test
    public void test3(){

        Class<Peron> clazz = Peron.class;
        // getFields():获取当前时运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        // getDeclaredFields():获取当前时运行时类所有的属性，不包含父类
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }

    /**
     * 权限修饰符    数据类型    变量
     */
    @Test
    public void test4(){
        Class<Peron> clazz = Peron.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            // 修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers));

            // 数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getName() + "\t");

            // 变量名
            String name = declaredField.getName();
            System.out.print(name);
            System.out.println();
        }
    }

    /**
     * 获取构造器
     */
    @Test
    public void otherTest1(){
        Class clzz = Peron.class;

        // getConstructors():获取当前运行类中生明为public的构造器
        Constructor[] constructors = clzz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        // getDeclaredConstructors():获取当前运行类中所有的构造器
        Constructor[] declaredConstructors = clzz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void otherTest2(){

        Class clazz = Peron.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

        // 带泛型的父类的泛型
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        // 泛型的类型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    /**
     * 获取运行时类指定参数
     */
    @Test
    public void otherTest3() throws Exception {

        Class<Peron> clazz = Peron.class;

        Peron peron = clazz.newInstance();
        // 获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        // 保证属性是可访问的
        name.setAccessible(true);
        // 获取、设置指定对象的此属性值
        name.set(peron, "Tom");

        System.out.println(name.get(peron));
    }

    /**
     * 如何操作运行时类中的方法
     */
    @Test
    public void test7() throws Exception{
        Class<Peron> clazz = Peron.class;
        // 获取指定的某个方法
        Peron peron = clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);

        show.setAccessible(true);

        // 方法返回值即为对应参数的方法的返回值, 没有返回值返回null
        Object chn = show.invoke(peron, "CHN");
        System.out.println(chn);

        System.out.println("***************静态方法***************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // Object invoke = showDesc.invoke(Peron.class);
        Object invoke = showDesc.invoke(null);
        System.out.println(invoke);

    }

    /**
     * 运行时类中指定的构造器
     */
    @Test
    public void test8() throws Exception{
        Class<Peron> clazz = Peron.class;

        Constructor<Peron> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);

        Peron peron = constructor.newInstance("Tom");

        System.out.println(peron);
    }

    /**
     * 获取运行时类的实现的接口
     */
    @Test
    public void otherTest6(){

        Class clazz = Peron.class;
        Class[] superclass = clazz.getInterfaces();
        for (Class aClass : superclass) {
            System.out.println(aClass);
        }
    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void otherTest4(){

        Class clazz = Peron.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     * 获取运行时类声明的注解
     */
    @Test
    public void otherTest5(){

        Class clazz = Peron.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Test
    public void test5(){
        Class clazz = Peron.class;

        // getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println();

        // getDeclaredMethods():获取当前运行时类中声明的方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        System.out.println();
    }

    @Test
    public void test6(){

        Class clazz = Peron.class;

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 获取方法声明的注解
            Annotation[] a = method.getAnnotations();
            for (Annotation annotation : a) {
                System.out.println(a);
            }
        }
    }


}
