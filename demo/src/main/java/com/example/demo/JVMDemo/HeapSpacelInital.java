package com.example.demo.JVMDemo;

public class HeapSpacelInital {

    /**
     * 1.设置堆空间内存大小
     *      -Xms 用来设置堆空间（年轻代 + 老年代）初始内存大小
     *          -X 是JVM的运行参数
     *          ms 是memory start
     *      -Xmx 用来设置堆空间（年轻代 + 老年代）的最大内存大小
     * 2. 默认设置大小
     *      默认情况下，初始内存的大小：物理电脑内存大小/64
     * 	              最大内存的大小：物理电脑内存大小/4
     *  3. 开发中建议将初始内存和最大内存设置成相同的值
     *  4. 查看设置的参数： 方式一：jps -> jstat -gc 进程号
     *                   方式二：-Xms600m -Xmx600m -XX:+PrintGCDetails
     * @param args
     */

    public static void main(String[] args) {

        // 返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // 返回Java虚拟机试图使用的最大堆内存存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms ：" + initialMemory + "M");
        System.out.println("-Xmx ：" + maxMemory + "M");

//        System.out.println("系统内存大小为：" + initialMemory * 64.0 / 1024 + "G");
//        System.out.println("系统内存大小为：" + maxMemory * 64.0 / 1024 + "G");

//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
}
