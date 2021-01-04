package com.example.demo.leetcode;

public class IsFlipedString {

    public static void main(String[] args) {
        IsFlipedString string = new IsFlipedString();
        boolean isFlag = string.isFlipedString("aba", "bab");
        System.out.println(isFlag);
    }

    public boolean isFlipedString(String s1, String s2) {

        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        s1 += s1;
        return s1.contains(s2);
    }
}
