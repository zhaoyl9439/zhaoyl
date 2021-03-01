package com.example.demo.utils;

public class ArrayUtils {

    public static <T> void change(T[] t, int firstIndex, int secondINdex) {
        T temp = t[firstIndex];
        t[firstIndex] = t[secondINdex];
        t[secondINdex] = temp;

    }
}
