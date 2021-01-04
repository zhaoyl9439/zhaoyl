package com.example.demo.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {4,5,6,3,7,1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(a,a.length);
        System.out.println(JSONObject.toJSONString(a));
    }


    public void insertionSort(int[] a, int n){
        long s1 = System.currentTimeMillis();
        if (n <= 1) return;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value){
                   a[j+1] = a[j];
                }else {
                    break;
                }
                num++;
            }
            a[j+1] = value;
        }
        System.out.println(num);
        long s2 = System.currentTimeMillis();
        System.out.println("耗时："+(s2-s1)+"毫秒");
    }

}
