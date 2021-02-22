package com.example.demo.generic;

import com.example.demo.utils.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.print.attribute.standard.MediaSizeName.A;

public class TestGeneric {


    @Test
    public void test() {

        Integer[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayUtils.change(arrInt, 2, 6);
        System.out.println("arrInt = " + Arrays.asList(arrInt));

        String[] arrStr = {"a", "b", "c", "d", "e", "f", "g"};
        ArrayUtils.change(arrStr, 2, 6);
        System.out.println("arrStr = " + Arrays.asList(arrStr));
    }

    @Test
    public void test1() {

        List<Father> listF = new ArrayList<>();
        List<Mother> listM = new ArrayList<>();
        List<Son> listS = new ArrayList<>();
        List<Daughter> listD = new ArrayList<>();
        testExtends(listF);
        testExtends(listS);
        //testExtends(listM);//false

        List<GrandSon> listG = new ArrayList<>();
        testSuper(listF);
        //testSuper(listG);//false
        testExtends(listG);

    }

    private static void testExtends(List<? extends Father> list) {

    }

    private static void testSuper(List<? super Son> list) {

    }
}

class Father{}

class Mother{}

class Son extends Father{

}

class GrandSon extends Son{

}

class Daughter extends Mother{

}
