package com.example.demo.test;

import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TestStringJoin {


    public static void main(String[] args) {

        List<String > appNos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            appNos.add(String.valueOf(i));
        }

        String s = "'" + StringUtils.join(appNos, "','") + "'";
        System.out.println(s);
    }
}
