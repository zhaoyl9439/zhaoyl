package com.example.demo.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysTest {


    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 4, 6, 8, 4};
        int[]  arr2 = new int[]{1, 4, 6, 8, 9};

        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.toString(arr1));
        Arrays.fill(arr1, 10); //替换
        System.out.println(Arrays.toString(arr1));
        Arrays.sort(arr2); //排序
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.binarySearch(arr2, 1)); //查找

    }

}

class ArrayPrintTest{

    public static void main(String[] args) {

        int[] n = new int[]{1, 2, 3};
        System.out.println(n); //[I@44e81672

        char[] c = new char[]{'a', 'b', 'c'};
        System.out.println(c); //abc
    }
}


class ChangeTest{

    public static void main(String[] args) {
        // 数组每个位置上的值除以收位置的元素，得到的结果作为该位置上的新值
        int[] arr = new int[]{12, 43, 64, 90, 78};
        for (int i = arr.length-1; i >=0; i--) {
            arr[i] = arr[i]/arr[0];
        }

        System.out.println(Arrays.toString(arr));
    }
}