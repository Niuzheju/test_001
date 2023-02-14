package com.niuzj.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzheju
 * @date 15:31 2021/8/9
 */
public class Test14 {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    @Test
    public void test01() {
        THREAD_LOCAL.set("test");
        test02();
    }

    private void test02() {
        String s = THREAD_LOCAL.get();
        System.out.println(s);
    }

    @Test
    public void test03() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
    }
}
