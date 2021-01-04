package com.example.demo.leetcode;

import static java.lang.Math.*;

public class OneEditAway {

    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * 找到较短字符的第一个字符，对比之后的字符串是否相同，若相同返回true
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(new OneEditAway().oneEditAway("horse", "ros"));
    }


    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len2 > len1) return oneEditAway(second, first);

        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)){
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i+1 : i));
            }
        }

        return true;
    }
}
