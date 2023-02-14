package com.niuzj.test;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author niuzheju
 * @date 16:56 2020/10/20
 */
public class DateTimeTest {

    /**
     * 日期
     * 时间
     * 日期 + 时间
     */
    @Test
    public void test01() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }


    /**
     * LocalDateTime转为毫秒
     * LocalDateTime和Instant互转需要指定时区
     */
    @Test
    public void test02() {
        Instant instant1 = LocalDateTime.now().toInstant(ZoneOffset.of("+8"));
        System.out.println(instant1.toEpochMilli());

        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());

        LocalDateTime localDateTime = Instant.now().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        System.out.println(localDateTime);
    }


    /**
     * LocalDateTime的格式化
     */
    @Test
    public void test03() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(format);

        LocalDateTime time = LocalDateTime.parse(format, dateTimeFormatter);
        System.out.println(time);

    }


    /**
     * Date和 LocalDateTime互转
     */
    @Test
    public void test04() {
        LocalDateTime localDateTime = new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        System.out.println(localDateTime);

        Date date = Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
        System.out.println(date);

    }

    /**
     * 获取LocalDateTime各个字段的值
     */
    @Test
    public void test05() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("年:" + now.getYear());
        System.out.println("月:" + now.getMonthValue());
        System.out.println("本年的第几天:" + now.getDayOfYear());
        System.out.println("本月的第几天:" + now.getDayOfMonth());
        System.out.println("本周的第几天:" + now.getDayOfWeek());
        System.out.println("小时:" + now.getHour());
        System.out.println("分钟:" + now.getMinute());
        System.out.println("秒钟:" + now.getSecond());
        System.out.println("增加天数:" + now.plusDays(5));
        System.out.println("增加天数:" + now.plus(5, ChronoUnit.DAYS));
        System.out.println("减少天数:" + now.minus(5, ChronoUnit.DAYS));
    }


}
