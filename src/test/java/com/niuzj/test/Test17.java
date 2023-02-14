package com.niuzj.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author niuzheju
 * @date 16:04 2021/12/3
 */
public class Test17 {

    @Test
    public void test01() {
        BigDecimal total = new BigDecimal("960000");
        BigDecimal pay = new BigDecimal("10000");
        BigDecimal times = new BigDecimal("360");
//        BigDecimal dayRate = new BigDecimal("0.0563").divide(new BigDecimal("360"), RoundingMode.HALF_UP);
        BigDecimal dayRate = new BigDecimal("0.00006087");
        BigDecimal monthRate = new BigDecimal("0.0563").divide(new BigDecimal("12"), RoundingMode.HALF_UP);
        LocalDateTime begin = LocalDateTime.of(2021, 2, 1, 0, 0, 0);
        LocalDateTime now = LocalDateTime.of(2022, 3, 19, 0, 0, 0);
        long day = Duration.between(begin, now).toSeconds() / 3600 / 24;
        BigDecimal days = new BigDecimal(day);
        System.out.println(days);
        BigDecimal totalPay = pay.multiply(dayRate).multiply(days).add(pay);

        System.out.println(totalPay);


        System.out.println(Math.pow(1.00006087, 360));


    }

    @Test
    public void test02() {
        BigDecimal monthRate = new BigDecimal("0.0563").divide(new BigDecimal("12"), 8, RoundingMode.HALF_UP);
        BigDecimal total = new BigDecimal("848353.95");
        int month = 349;
        BigDecimal one = new BigDecimal("1");
        BigDecimal x = one.add(monthRate).pow(month);
        BigDecimal pay = total.multiply(monthRate).multiply(x).divide(x.subtract(one), 8, RoundingMode.HALF_UP);
        System.out.println(pay);

    }

    @Test
    public void test03() {
        char[] src = {'x', 'x', 'x', 'x', 'y'};
        char[] dest = new char[0];
        System.arraycopy(src, 5, dest, 0, 0);
        System.out.println(Arrays.toString(dest));
    }
}
