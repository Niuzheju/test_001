package com.niuzj.test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: niuzheju
 * @Date: 15:37  2020/6/6
 */
public class Test9 {
    @Test
    public void test01() {
        try {
            Person.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("test01");

    }

    @Test
    public void test02() {
        try {
            Person.class.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("test01");

    }
}

class Person {
    public Person() throws Exception {
        throw new Exception();
    }
}
