package com.example.demo.JVMDemo;


/**
 * 测试堆空间常用的jvm参数
 * -XX:+PrintFlagsInitial : 查看所有参数的默认值
 * -XX:+PrintFlagsFinal : 显示所有可设置的参数及它们的值(可能存在修改，不再试初始值)
 *      具体查看某个参数的指令 : jps:查看当前运行中的进程
 *                           jinfo -flag SurvivorRatio 进程ID
 * -Xms : 初始空间内存（默认是物理内存的1/64）
 * -Xmx : 最大堆空间内存（默认为物理内存的1/4）
 * -Xmn: 设置新生代的大小（初始值及最大值）
 * -XX:NewRatio : 设置新生代与老年代在堆结构的占比
 * -XX：SurvivorRatio : 设置新生代中Eden和S0/S1空间的比例
 * -XX:MaxTenuringThreshold : 设置新生代垃圾的最大年龄
 * -XX:+PrintGCDetails : 设置新生代垃圾的最大年龄
 * 打印GC简要信息：①-XX:PrintGC   ②-verbose:gc
 * -XX:HandlePromotionFailure : 是否设置空间分配担保
 */
public class HeapArgsTest {

    public static void main(String[] args) {

    }
}
