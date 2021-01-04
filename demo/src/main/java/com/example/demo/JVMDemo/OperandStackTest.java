package com.example.demo.JVMDemo;

public class OperandStackTest {

    public void testAddOperation(){
        // byte short char boolean 都以int来存放
        byte i = 16;
        int j = 18;
        int k = i + j;

        int m = 800;
    }

    public int getSum(){

        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    public void tesGetSum(){
        // 获取上一个栈帧返回的结果并保存在操作数栈中
        int i = getSum();
        int j = 10;

    }


}
