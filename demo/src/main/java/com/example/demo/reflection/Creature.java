package com.example.demo.reflection;

import java.io.Serializable;

public class Creature<T> implements Serializable {

    private char gender;
    public double weigh;

    private void brath(){
        System.out.println("生物呼吸~");
    }

    public void eat(){
        System.out.println("生物吃东西~");
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getWeigh() {
        return weigh;
    }

    public void setWeigh(double weigh) {
        this.weigh = weigh;
    }
}
