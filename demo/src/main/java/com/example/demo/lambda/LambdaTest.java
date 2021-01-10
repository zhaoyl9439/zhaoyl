package com.example.demo.lambda;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;


/**
 * (o1, o2) ->Integer.compare(o1, o2)
 * 格式：
 *      ->：lambda操作符
 *      ->左边：lambda形参列表（接口中抽象方法的形参列表）
 *      ->右边：lambda体（重写的抽象方法的方法体）
 */
public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("花花~~");
            }
        };
        r1.run();

        // 语法格式一：无参，无返回值
        Runnable r2 = ()-> System.out.println("大王~~");
        r1.run();
    }

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 14);
        System.out.println(compare1);
        System.out.println("===================");

        Comparator<Integer> com2 = (o1, o2) ->Integer.compare(o1, o2);
        int compare2 = com2.compare(17, 14);
        System.out.println(compare2);
        System.out.println("===================");

        // 方法的引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com2.compare(30, 14);
        System.out.println(compare3);
        System.out.println("===================");

    }

    @Test
    public void test3(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("test3");
        System.out.println("===================");

        // 语法格式二：需要一个参数，没有返回值
        Consumer<String> consumer2 = (String s) -> {
                System.out.println(s);
        };
        consumer2.accept("test3");
        System.out.println("===================");

        Consumer<String> consumer3 = s -> System.out.println(s);
        consumer3.accept("test3");
        System.out.println("===================");

        PrintStream ps = System.out;
        Consumer<String> consumer4 = ps :: println;
        consumer4.accept("test3");
        System.out.println("===================");
    }

    @Test
    public void test4(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("test4");
        System.out.println("===================");

        // 语法格式三：类型推断
        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.accept("test4");
        System.out.println("===================");
    }

    @Test
    public void test5(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("test5");
        System.out.println("===================");

        // 语法格式四：若只需要一个参数，参数的小括号可以省略
        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer2.accept("test5");
        System.out.println("===================");
    }


    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(12, 23));
        System.out.println("===================");

        // 语法格式五：Lambda需要两个或者两个以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com2 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println(com2.compare(42, 23));
        System.out.println("===================");
    }

    @Test
    public void test7(){
        Comparator<Integer> com1 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println(com1.compare(42, 23));
        System.out.println("===================");

        // 语法格式六：Lambda体只有一条语句时，return 与大括号若有,都可以省略;
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(23, 45));
        System.out.println("===================");

    }

    @Test
    public void test8(){
        Employee emp = new Employee(1001, "Tom", 26, 5_600);

        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());
        System.out.println("===================");

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup1.get());
        System.out.println("===================");

    }

    @Test
    public void test9(){

        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21));
        System.out.println("===================");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com1.compare(32, 21));
        System.out.println("===================");

        Function<Double, Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println(function1.apply(12.4));
        System.out.println("===================");

        Function<Double, Long> function2 = d -> Math.round(d);
        System.out.println(function1.apply(12.6));
        System.out.println("===================");

        Function<Double, Long> function3 = Math::round;
        System.out.println(function1.apply(12.6));
        System.out.println("===================");

    }

    @Test
    public void test10(){
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("adc", "abd"));
        System.out.println("===================");

        Comparator<String> com2= String :: compareTo;
        System.out.println(com1.compare("adc", "abd"));
        System.out.println("===================");

        BiPredicate<String, String> prd1 = (s1, s2) -> s1.equals(s2);
        System.out.println(prd1.test("adc", "abc"));
        System.out.println("===================");

        BiPredicate<String, String> prd2 = String :: equals;
        System.out.println(prd1.test("adc", "abc"));
        System.out.println("===================");

    }

    @Test
    public void test11(){

        Employee employee = new Employee(1001, "Jerry", 23, 1006);

        Function<Employee, String > fun1 = e -> e.getName();
        System.out.println(fun1.apply(employee));
        System.out.println("===================");

        Function<Employee, String > fun2 = Employee :: getName;
        System.out.println(fun1.apply(employee));
        System.out.println("===================");

    }

    @Test
    public void test12(){
        Supplier<Employee> sup1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup1.get());
        System.out.println("===================");

        Supplier<Employee> sup2 = () -> new Employee();
        System.out.println(sup1.get());
        System.out.println("===================");

        Supplier<Employee> sup3 = Employee::new;
        System.out.println(sup3.get());
        System.out.println("===================");

    }

    @Test
    public void test13(){
        Function<Integer , Employee> func2 = id -> new Employee(id);
        Employee employee1 = func2.apply(1001);
        System.out.println(employee1);
        System.out.println("===================");

        Function<Integer , Employee> func3 = Employee::new;
        Employee employee2 = func3.apply(1002);
        System.out.println(employee2);
        System.out.println("===================");
    }

    @Test
    public void test14(){
        BiFunction<Integer, String, Employee> func1 = (id, name) -> new Employee(id, name);
        System.out.println(func1.apply(1001, "Tom"));
        System.out.println("===================");

        BiFunction<Integer, String, Employee> func2 = Employee::new;
        System.out.println(func1.apply(1001, "Tom"));
        System.out.println("===================");
    }

    /**
     * 数组引用
     */
    @Test
    public void test15(){

        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));
        System.out.println("===================");

        Function<Integer, String[]> func2 = String[] :: new;
        String[] arr2 = func1.apply(5);
        System.out.println(Arrays.toString(arr2));
        System.out.println("===================");

    }



}
