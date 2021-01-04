package com.example.demo.study;

import com.alibaba.fastjson.JSONObject;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubleSort(a);
        System.out.println(JSONObject.toJSONString(a));
    }

    /**
     * 冒泡排序
     * @param a
     */
    public void bubleSort(int[] a){
        long s1 = System.currentTimeMillis();
        if (a != null && a.length <= 1) return;
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i -1 ; j++) {
                if (a[j] > a[j + 1]) { //判断大小
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp; //交换数据
                    flag = true;
                }
                num++;
            }
            if (!flag) break; //判断是否有数据交换
        }
        System.out.println(num);
        long s2 = System.currentTimeMillis();
        System.out.println("耗时："+(s2-s1)+"毫秒");
    }


}
