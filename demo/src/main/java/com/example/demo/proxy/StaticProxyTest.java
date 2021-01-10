package com.example.demo.proxy;


/**
 * 静态代理：代理类和被代理类在编译期就确定下来了
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        // 被代理类
        NikeCloseFactory nikeCloseFactory = new NikeCloseFactory();

        // 代理类
        ProxyClothFactory factory = new ProxyClothFactory(nikeCloseFactory);

        factory.productCloth();
    }

}

interface ClothFactory{
    void productCloth();
}

class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void productCloth() {
        System.out.println("准备工作~");

        factory.productCloth();

        System.out.println("结束工作~");
    }
}

class NikeCloseFactory implements ClothFactory{
    @Override
    public void productCloth() {
        System.out.println("Nike生产衣服~~");
    }
}

