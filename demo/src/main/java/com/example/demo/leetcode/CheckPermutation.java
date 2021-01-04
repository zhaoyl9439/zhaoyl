package com.example.demo.leetcode;

import com.alibaba.fastjson.JSONObject;

public class CheckPermutation {

    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * @param args
     */
    public static void main(String[] args) {
        CheckPermutation solution = new CheckPermutation();
        int[] a = {-5,0,4};
        int[] b = {-4,0,5};
        System.out.println(solution.checkPermutation("aac", "bbb"));
        System.out.println(solution.checkPermutation(JSONObject.toJSONString(a), JSONObject.toJSONString(b)));

    }

    public boolean checkPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int a1 = 0;
        int a2 = 0;
        int b1 = 1;
        int b2 = 1;
        for (int i = 0; i < s1.length(); i++) {
            a1 += s1.charAt(i);
            a2 += s2.charAt(i);
            b1 *=s1.charAt(i);
            b2 *= s2.charAt(i);
        }
        if (a1 == a2 && b1 == b2 )return true;
        return  false;
    }

    public boolean checkPermutation2(String s1, String s2){

        if (s1.length() != s2.length()) return false;

        int[] index = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            index[s1.charAt(i)]++;
            index[s2.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (index[i] !=0) return false;
        }
        return true;
    }
}
