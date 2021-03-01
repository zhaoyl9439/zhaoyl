package com.example.demo.thread;

public class TaxCalcCulationMain {

    public static void main(String[] args) {

        /*TaxCalaculation calaculator = new TaxCalaculation(10000d, 20000d){
            @Override
            public double calcTax() {
                return getSalary() * 0.1 + getBonus()*0.15;
            }
        };
        double tax = calaculator.calcTax();
        System.out.println(tax);*/

        // 策略模式
        TaxCalaculation calaculator = new TaxCalaculation(10000d, 20000d);
        CalculatiorStratrgy stratery = new SimpleCalculatorStratery();
        calaculator.setCalculatiorStratrgy(stratery);

        System.out.println(calaculator.calculate());

    }

}
