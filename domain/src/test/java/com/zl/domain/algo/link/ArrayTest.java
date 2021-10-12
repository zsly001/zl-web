package com.zl.domain.algo.link;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void getMaxLength(){
        int[] arr = {3,1,6,1,2};
        int k = 3;
        int maxLength = Array.getMaxLength(arr, k);
        System.out.println(maxLength);
    }

}
