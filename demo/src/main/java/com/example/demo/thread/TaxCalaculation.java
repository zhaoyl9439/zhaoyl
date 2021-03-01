package com.example.demo.thread;

public class TaxCalaculation {

    private final double salary;

    private final double bonus;

    private CalculatiorStratrgy calculatiorStratrgy;

    public TaxCalaculation(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double calcTax(){
        return calculatiorStratrgy.calculate(salary, bonus);
    }

    public double calculate(){
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setCalculatiorStratrgy(CalculatiorStratrgy calculatiorStratrgy) {
        this.calculatiorStratrgy = calculatiorStratrgy;
    }
}
