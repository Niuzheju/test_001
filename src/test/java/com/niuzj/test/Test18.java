package com.niuzj.test;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author niuzheju
 * @Date 15:27 2022/8/23
 */
public class Test18 {

    @Test
    public void test01() throws IOException {
        String s = "[{\"key\":\"颜色\", \"value\":\"黑色\"}, {\"key\":\"大小\", \"value\":\"大\"}]";
        System.out.println(s.hashCode());

    }

    @Test
    public void test02(){
        Long credit = 10L;
        Long a = (long) Math.ceil((credit.doubleValue() / 3) * 3);
        System.out.println(a);
    }
}
