package com.example.demo.generic;

import java.util.List;

public class BaseDAO<T> {

    public void add(T t){

    }

    public boolean remove(int index ){
        return false;
    }

    public void update(int index, T t){

    }

    public T getIndex(int index){
        return null;
    }

    public List<T> getForList(int index){
        return null;
    }

    public <E> E getVaue(){
        return null;
    }
}
