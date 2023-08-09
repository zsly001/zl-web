package com.zl.domain.algo.thd;

public interface Blocking<T> {

    boolean put(T value)  throws InterruptedException;

    T take()  throws InterruptedException;

    int size();

    boolean isEmpty();

    int getMax();

}
