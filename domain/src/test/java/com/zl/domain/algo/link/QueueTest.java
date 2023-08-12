package com.zl.domain.algo.link;

import com.zl.domain.algo.thd.*;
import com.zl.domain.util.Util;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {


    public static void main(String[] args) {

        final Blocking<Integer> q = new LinkedSyn2Blocking<>();
        //ArrayBlockingQueue q = new ArrayBlockingQueue(10);
        Runnable p = new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<15;i++){
                        q.put(i);
                        System.out.println(Thread.currentThread().getName()+" Put :"+i);
                        Util.sleep(1);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable c = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+" Take :"+ q.take());
                        Util.sleep(2);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();

        /*new Thread(new P(q)).start();
        new Thread(new C(q)).start();
        new Thread(new C(q)).start();*/

        //LinkedSynBlocking<Integer> q = new LinkedSynBlocking<>();
        /*try {
            for(int i=0;i<100;i++){
                q.put(i);
                System.out.println("put "+i);
            }
            *//*while (!q.isEmpty()){
                System.out.println(q.takeHead());
            }*//*
            System.out.println("size :"+q.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


    public static class P implements Runnable{
        Blocking<Integer> q;

        public P(Blocking<Integer> q) {
            this.q = q;
        }

        @Override
        public void run() {
            try {
                for(int i=0;i<15;i++){
                    q.put(i);
                    System.out.println(Thread.currentThread().getName()+" Put :"+i);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class C implements Runnable{
        Blocking<Integer> q;

        public C(Blocking<Integer> q) {
            this.q = q;
        }

        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" Take :"+ q.take());
                    Util.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
