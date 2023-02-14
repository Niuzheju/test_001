package com.niuzj.test;

import org.junit.Test;

import java.util.Random;

/**
 * 随机数
 */
public class Test6 {

    @Test
    public void test1(){
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println(i);
    }

    @Test
    public void test2(){
        double b = Math.floor(Math.random() * 10);
        System.out.println(Double.valueOf(b).intValue());

    }
}
