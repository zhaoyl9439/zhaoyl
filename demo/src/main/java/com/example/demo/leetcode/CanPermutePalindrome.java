package com.example.demo.leetcode;

import java.util.HashSet;

public class CanPermutePalindrome {

    public static void main(String[] args) {
        CanPermutePalindrome canPermutePalindrome = new CanPermutePalindrome();
        System.out.println(canPermutePalindrome.canPermutePalindrome("taccoa"));
    }

    /**
     * 将字符放入hashSet（无序不可重复）中，判断放入成功与否，
     * 如果放入失败即为已经放入过的字符，既字符串为重复字符串，
     * 移除该字符串即可判断出是否为回文串中重复的字符，
     * 最后判断hashset的下标，若为回文串则最大为1
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (!set.add(c)){
                set.remove(c);
            }
        }
        return set.size()<=1;
    }

}
