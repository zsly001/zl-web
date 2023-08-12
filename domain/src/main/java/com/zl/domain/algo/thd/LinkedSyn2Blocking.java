package com.zl.domain.algo.thd;

public class LinkedSyn2Blocking<T> extends LinkedBlocking<T>{


    public LinkedSyn2Blocking(int maxSize) {
        super(maxSize);
    }

    public LinkedSyn2Blocking() {
        super();
    }

    @Override
    public synchronized boolean put(T value) throws InterruptedException {

        if(size == maxSize){
            wait();
        }
        addTail(value);
        notify();
        return true;
    }

    @Override
    public synchronized T take() throws InterruptedException {
        if(size ==  0){
            wait();
        }
        T t = takeHead();
        notify();
        return t;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized boolean isEmpty() {
        return size == 0;
    }
}
