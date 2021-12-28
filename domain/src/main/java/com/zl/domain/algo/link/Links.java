package com.zl.domain.algo.link;

public class Links {

    private Node head;

    private Node tail;

    private int size;


    public Links() {
    }

    public void add(Object val){
        Node n = new Node();
        n.data = val;
        if(null==head && null==tail){
            head = n;
            tail = n;
        }else {
            tail.next = n;
            tail = n;
        }
        size ++;
    }

    public Object getPop(){
        if (null==head){
            return null;
        }
        Node r = head;
        head = head.next;
        size--;
        return r.data;
    }

    public void reverse(){

        Node pre = null;
        Node cur = head;
        Node nep = head.next;
        while (true){
            cur.next = pre;
            pre = cur;
            cur = nep;
            if(null==cur){
                break;
            }
            nep = nep.next;
        }
        head = pre;
    }

    private static class Node {
        Object data;

        Node next;

    }

}
