package com.zl.domain.algo.thd;

public abstract class LinkedBlocking<T> implements Blocking<T>{

    public static final int MAX_LEN = 10;

    private Node head;
    private Node tail;

    protected int size;
    protected int maxSize;

    public LinkedBlocking(int maxSize) {
        this.maxSize = maxSize;
    }

    public LinkedBlocking() {
        maxSize = MAX_LEN;
    }

    public boolean addTail(T value){
        Node<T> node = new Node<>(value);
        if(null == head && null == tail){
            head = node;
            tail = node;
        }else {
            tail.setNext(node);
            tail = node;
        }
        size++;
        return true;
    }


    public T takeHead(){
        if(null == head){
            return null;
        }
        Node<T> tmp = head;
        T data = tmp.getData();
        head = tmp.getNext();
        if(null == head){
            tail = head;
        }
        //tmp = null;
        size--;
        return data;
    }

    @Override
    public int getMax() {
        return maxSize;
    }

    public static class Node<T>{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
