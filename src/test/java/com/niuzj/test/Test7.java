package com.niuzj.test;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Test7 {

    /**
     * 虽然可以指定一个数值为内部数组的长度
     * 可是实际初始化后的数组长度并不是我们指定的数值,而是离参数最近且大于参数且是2的n次幂
     * 比如传入3,实际长度是4
     * 传入13,实际长度是16
     */
    @Test
    public void test01() {
        Map<String, Integer> map = new HashMap<>(13);
        map.put("1", 1);
        System.out.println(map.get("1"));
    }

    @Test
    public void test02() {
        String[] s = new String[0];
        System.out.println(Arrays.toString(s));
    }

    @Test
    public void test03() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        long sec = 3600;
        runtime.exec("shutdown -s -t " + sec);
    }

    @Test
    public void test04() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("shutdown -a");
    }

    @Test
    public void test05(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 18); 
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        long time1 = cal.getTimeInMillis();
        long time2 = System.currentTimeMillis();
        long hourUnit = 3600;
        long minuteUnit = 60;
        long total = (time1 - time2) / 1000;
        long hour = total / 3600;
        long minute = (total - hour * hourUnit) / minuteUnit;
        System.out.println(hour + "小时" + minute + "分钟");
    }

    @Test
    public void test06(){
        System.out.println(Math.cos(Math.toRadians(0)));
    }

    /**
     * Integer.toBinaryString 把int转为二进制
     * Integer.toHexString(a) 把int转为16进制
     */
    @Test
    public void test07(){
        byte b = -8;
        int a = b;
        System.out.println(a);
        System.out.println(a & 0xFF);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a & 0xFF));
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(a & 0xFF));
    }

    /**
     * 16进制字符串解析为int
     */
    @Test
    public void test08(){
        System.out.println(Integer.parseInt("F", 16));
    }

    @Test
    public void test09(){
        System.out.println(4 % 3);
    }

    @Test
    public void test10(){
        int n = 6;
        System.out.println(tableSizeFor(6));
    }

    public int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    @Test
    public void test11(){
        PrintStream out = System.out;
        out.println("<table>");
        for (int i = 1; i <= 10; i++) {
            out.print("<th>");
            for (int j = i; j <= i * 10; j = j + i) {
                out.print("<td>" + j + "</td>");
            }
            out.print("</th>");
            out.println();
        }
        out.println("</table>");
    }
}
