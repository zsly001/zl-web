package com.zl.domain.algo.thd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayLock2BLocking<T> extends ArrayBlocking<T>{

    private ReentrantLock lock;

    private Condition notEmpty;

    private Condition notFull;


    public ArrayLock2BLocking() {
        super();
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public ArrayLock2BLocking(int maxSize) {
        super(maxSize);
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    @Override
    public boolean put(T value) throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if(size == getMax()){
                notFull.await();
            }
            addTail(value);
            notEmpty.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T take() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lock();
        T t;
        try {
            if(isEmpty()){
                notEmpty.await();
            }
            t = takeHead();
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return t;
    }

    @Override
    public int size() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return 0 == size;
        } finally {
            lock.unlock();
        }
    }
}
