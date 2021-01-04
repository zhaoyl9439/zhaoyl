package com.example.demo.JVMDemo;


/**
 * -Xms600m -Xmx600m
 * -XX:NewRatio : 设置新生代与老年代的比例。默认值是2
 * -XX:SurvivorRatio=8 : 设置新生代中Eden区与Survivor区的比例
 * -XX:-UseAdaptiveSizePolicy : 关闭自适应的内存分配策略(暂时用不到)
 * jps -> jinfo -flag NewRatio 进程号 : 查看老年代占比
 * -Xmn ：设置新生代最大内存大小（一般不设置）
 */
public class EdenSurvivorTest {

    public static void main(String[] args) {
        System.out.println("新生代与老年代在对堆结构的占比配置");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
