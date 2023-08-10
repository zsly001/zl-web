package com.zl.domain.algo.link;

import com.zl.domain.algo.thd.*;
import com.zl.domain.util.Util;

public class QueueTest {


    public static void main(String[] args) {

        final Blocking<Integer> q = new LinkedSynBlocking<>();
        Runnable p = new Runnable() {
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
        };

        Runnable c = new Runnable() {
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
        };

        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();

        /*LinkedSynBlocking<Integer> q = new LinkedSynBlocking<>();
        for(int i=0;i<100;i++){
            q.addTail(i);
        }
        while (!q.isEmpty()){
            System.out.println(q.takeHead());
        }
        System.out.println("size :"+q.size());*/
    }


}
