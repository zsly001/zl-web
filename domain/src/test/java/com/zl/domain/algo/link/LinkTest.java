package com.zl.domain.algo.link;

import org.junit.Test;

public class LinkTest {

    @Test
    public void print(){

        Links links = new Links();
        for(int n=0;n<100;n++){
            links.add(n);
        }

        for(int i=0;i<100;i++){
            Object pop = links.getPop();
            System.out.println(pop);
        }


    }


    @Test
    public void reverse(){
        Links links = new Links();
        for(int n=0;n<10;n++){
            links.add(n);
        }
        links.reverse();
        for(int i=0;i<10;i++){
            Object pop = links.getPop();
            System.out.println(pop);
        }
    }


}
