package com.zl.domain.algo.thd;

public class LinkedSyn2Blocking<T> extends LinkedBlocking<T>{


    public LinkedSyn2Blocking(int maxSize) {
        super(maxSize);
    }

    public LinkedSyn2Blocking() {
        super();
    }

    @Override
    public boolean put(T value) throws InterruptedException {
        synchronized (this){
            if(super.size == maxSize){
                this.wait();
            }
            addTail(value);
            this.notify();
            return true;
        }
    }

    @Override
    public T take() throws InterruptedException {
        synchronized (this){
            if(size ==  0){
                this.wait();
            }
            T t = takeHead();
            this.notify();
            return t;
        }
    }

    @Override
    public int size() {
        synchronized (this){
            return size;
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (this){
            return size == 0;
        }
    }
}
