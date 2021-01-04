package com.example.demo.leetcode;

public class ReplaceSpaces {

    public static void main(String[] args) {
        ReplaceSpaces replaceSpaces = new ReplaceSpaces();
        System.out.println(replaceSpaces.replaceSpaces1("Mr John Smith    ", 13));
        System.out.println(replaceSpaces.replaceSpaces2("Mr John Smith    ", 13));
        System.out.println(replaceSpaces.replaceSpaces3("Mr John Smith    ", 13));

    }

    public String replaceSpaces1(String S, int length) {

        return S.substring(0, length).replace(" ","%20");
    }

    public String replaceSpaces2(String S, int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public String replaceSpaces3(String S, int length){
        char[] cs = new char[length * 3];
        int i = 0, j = 0;
        while (i < length){
            if (S.charAt(i) == ' '){
                cs[j++] = '%';
                cs[j++] = '2';
                cs[j++] = '0';
            }else {
                cs[j++] = S.charAt(i);
            }
            i++;
        }
        return new String(cs,0,j);
    }

}