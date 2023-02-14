package com.niuzj.test;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class Test1 {

    @Test
    public void test01() throws IOException {
        String file = "E:\\公司代码\\sql\\乐游钱包数据\\cf_lexiangjingjidb.sql";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    @Test
    public void test02() throws IOException {
        String file = "E:\\公司代码\\sql\\乐游钱包数据\\cf_lexiangjingjidb.sql";
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int len = -1;
        byte[] data = new byte[1024 * 1024];
        int total = 0;
        while ((len = bufferedInputStream.read(data)) != -1) {
            total += len / 1024;
            System.out.println(total);
        }
        bufferedInputStream.close();
    }

    @Test
    public void test03() {
        System.out.println(Arrays.toString("牛".getBytes()));
    }

    @Test
    public void test04() {
        Object obj = new String[]{"a", "b"};
        Object[] s = (Object[]) obj;
        System.out.println(Arrays.toString(s));
    }

    @Test
    public void test05() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[2];
        System.out.println(stackTraceElement.getClassName());
        System.out.println(stackTraceElement.getMethodName());
        System.out.println(stackTraceElement.getLineNumber());
    }


    private static void print(MyFunction<Object> consumer) {
        consumer.print("niuzheju");
        Class<? extends MyFunction> aClass = consumer.getClass();
        System.out.println(aClass);

    }


    public static void main(String[] args) throws IOException {
        print((t) -> System.out.println("nzj".equals(t)));
        print(System.out::println);


    }
}

@FunctionalInterface
interface MyFunction<T> {

    void print(T t);

}
