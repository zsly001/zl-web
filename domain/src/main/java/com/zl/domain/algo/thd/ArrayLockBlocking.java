package com.zl.domain.algo.thd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayLockBlocking<T> extends ArrayBlocking<T>{

    private ReentrantLock lock = new ReentrantLock();

    private Condition available = lock.newCondition();

    @Override
    public boolean put(T value) throws InterruptedException{
        lock.lock();
        boolean ret = false;
        try {
            while (size == getMax()){
                available.await();
            }
            ret = addTail(value);
            available.signal();
        } finally {
            lock.unlock();
        }
        return ret;
    }

    @Override
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (isEmpty()){
                available.await();
            }
            T t = takeHead();
            available.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return 0 == size;
        } finally {
            lock.unlock();
        }
    }
}
