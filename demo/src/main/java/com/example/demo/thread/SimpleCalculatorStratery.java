package com.example.demo.thread;

public class SimpleCalculatorStratery implements CalculatiorStratrgy{

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE ;
    }
}
