package com.example.demo.compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareTest {

    @Test
    public void test1(){
        String[] s1 = {"11", "99", "88", "44", "77"};
        Arrays.sort(s1); //从小到大排序
        System.out.println(Arrays.toString(s1));
    }


    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods(12, "小米");
        arr[1] = new Goods(9, "戴尔");
        arr[2] = new Goods(80, "联想");
        arr[3] = new Goods(36, "联想");
        arr[4] = new Goods(120, "苹果");

        Arrays.sort(arr);
        System.out.print(Arrays.toString(arr));
    }

    @Test
    public void test3(){
        String[] s1 = {"11", "99", "88", "44", "77"};
        Arrays.sort(s1, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("传入数据类型不符合");
            }
        });
        System.out.println(Arrays.toString(s1));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods(12, "c小米");
        arr[1] = new Goods(9, "a戴尔");
        arr[2] = new Goods(80, "g联想");
        arr[3] = new Goods(36, "z联想");
        arr[4] = new Goods(120, "b苹果");

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("传入数据类型不符合");
            }
        });
        System.out.print(Arrays.toString(arr));
    }

    @Test
    public void test5(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods(12, "c小米");
        arr[1] = new Goods(9, "a戴尔");
        arr[2] = new Goods(80, "g联想");
        arr[3] = new Goods(36, "z联想");
        arr[4] = new Goods(120, "b苹果");
        List<Goods> list = Arrays.asList(arr);
        // list.sort(Comparator.comparing(Goods::getPrice));
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;
                return -Double.compare(g1.getPrice(), g2.getPrice());
            }
        });
        System.out.print(Arrays.toString(arr));
    }

}
