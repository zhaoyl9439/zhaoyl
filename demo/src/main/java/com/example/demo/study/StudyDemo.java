package com.example.demo.study;

import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;

public class StudyDemo {

    Object someParams = "0";
    String value1 = "1";
    String value2 = "2";
    String value3 = "3";

    public void originalIfElse(Object param){

        if (param.equals(value1)) {
            doAction1(someParams);
        } else if (param.equals(value2)) {
            doAction2(someParams);
        } else if (param.equals(value3)) {
            doAction3(someParams);
        }
    }

//    public void reconsitutionIfElse(Object param){
//        Map<?, Function<?> action> actionMappings = new HashMap<>(); // 这里泛型 ? 是为方便演示，实际可替换为你需要的类型
//
//        actionMappings.put(value1, someParams -> doAction1(someParams));
//        actionMappings.put(value2, someParams -> doAction2(someParams));
//        actionMappings.put(value3, someParams -> doAction3(someParams));
//
//        // 省略 null 判断
//        actionMappings.get(param).apply(someParams);
//
//    }


    private void doAction1(Object someParams) {
        System.out.println("doAction1()");
    }

    private void doAction2(Object someParams) {
        System.out.println("doAction2()");
    }

    private void doAction3(Object someParams) {
        System.out.println("doAction3()");
    }


    public static void main(String[] args) {
        int x = 1;
        int y = 2;


    }


}

//@FunctionalInterface
//interface actionMappings{
//    void doAction1();
//
//    void doAction2();
//
//    void doAction3();
//}
