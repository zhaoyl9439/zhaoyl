package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *实现动态代理，需要解决的问题？
 * 1：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象？
 * 2：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法？
 */
public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance 代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        // 当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");

        NikeCloseFactory nikeCloseFactory = new NikeCloseFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeCloseFactory);
        proxyClothFactory.productCloth();

    }

}

interface Human{
    String getBelief();

    void eat(String food);
}

class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("喜欢吃：" + food);
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("================方法一================");
    }

    public void method2(){
        System.out.println("================方法二================");
    }
}

class ProxyFactory{
    // 调用此方法，返回一个代理类对象，解决问题一
    public static Object getProxyInstance(Object obj){ // obj:被代理类对象

        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj; //需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下方法：invoke()
    // 将被代理类要执行的方法a的功能就声明在 invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        // method：即为代理类对象调用的方法，此方法也就是为了被代理类对象要调用的方法
        // obj：被代理类的对象
        //
        humanUtil.method1();

        Object invoke = method.invoke(obj, args);

        humanUtil.method2();
        return invoke;
    }
}