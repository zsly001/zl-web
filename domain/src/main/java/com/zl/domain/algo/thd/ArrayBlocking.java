package com.zl.domain.algo.thd;

public abstract class ArrayBlocking<T> implements Blocking<T>{

    public static final int MAX_LEN = 10;

    protected int size;

    private T[] data;

    private int maxLen;

    public ArrayBlocking() {
        maxLen = MAX_LEN;
        data = (T[])new Object[maxLen];
    }

    public ArrayBlocking(int maxSize) {
        maxLen = maxSize;
        data = (T[])new Object[maxLen];
    }

    public boolean addTail(T value){
        if((null != value) && (size < data.length)){
            data[size++] = value;
            return true;
        }
        return false;
    }

    public T takeHead(){
        if(isEmpty()){
            return null;
        }
        T value = data[0];
        for(int i=1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        return value;
    }

    @Override
    public int getMax() {
        return maxLen;
    }
}
