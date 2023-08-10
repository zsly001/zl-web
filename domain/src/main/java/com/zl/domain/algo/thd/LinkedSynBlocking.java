package com.zl.domain.algo.thd;

public class LinkedSynBlocking<T> extends LinkedBlocking<T>{

    private final Object lock = new Object();

    public LinkedSynBlocking(int maxSize) {
        super(maxSize);
    }

    public LinkedSynBlocking() {
        super();
    }

    @Override
    public boolean put(T value) throws InterruptedException {
        synchronized (lock){
            if(size == maxSize){
                System.out.println("Before put wait lock is "+lock+Thread.currentThread().getName());
                lock.wait();
                System.out.println("After put wait lock is "+lock+Thread.currentThread().getName());
            }
            addTail(value);
            lock.notify();
            return true;
        }
    }

    @Override
    public T take() throws InterruptedException {
        synchronized (lock){
            if(size ==  0){
                System.out.println("Before take wait lock is "+lock+Thread.currentThread().getName());
                lock.wait();
                System.out.println("After take wait lock is "+lock+Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName()+" take size is "+size+", lock is "+lock);
            T t = takeHead();
            lock.notify();
            return t;
        }
    }

    @Override
    public int size() {
        synchronized (lock){
            return size;
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (lock){
            return size == 0;
        }
    }
}
