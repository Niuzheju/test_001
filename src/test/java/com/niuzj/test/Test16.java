package com.niuzj.test;

import com.niuzj.model.User;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author niuzheju
 * @date 16:13 2021/8/23
 */
public class Test16 {

    @Test
    public void test01() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        map.replace(1, 3);
        Map<Integer, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put(4, 5);
        System.out.println(unmodifiableMap);

    }

    @Test
    public void test02() {
        File file = new File("E:\\Desktop\\txt\\万历十五年.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.getName());
    }

    @Test
    public void test03() {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }

    @Test
    public void test04() throws IntrospectionException, NoSuchFieldException {
        PropertyDescriptor pd = new PropertyDescriptor("roles", User.class);
        System.out.println(pd);
        System.out.println(pd.getReadMethod());
        System.out.println(pd.getWriteMethod());
        System.out.println(pd.getPropertyType());
        Class<?> parameterType = pd.getWriteMethod().getParameterTypes()[0];
        System.out.println(parameterType);
        System.out.println(parameterType.getTypeParameters()[0].getBounds()[0]);

        Type type = ((ParameterizedType) (User.class.getDeclaredField(pd.getName())
                .getGenericType())).getActualTypeArguments()[0];
        System.out.println(type);
    }

    @Test
    public void test05() {
        System.out.println("xxx".contains("xxx"));
    }


    @Test
    public void test06() {
        float a = 0.66666666666666666666666f;
        double b = 0.888888888888888888888888d;
        double sum = a * b;
        System.out.println(sum);
    }

    @Test
    public void test07() {
        Subject s1 = new Subject("001", "精通", "10");
        Subject s2 = new Subject("002", "掌握", "20");
        Subject s3 = new Subject("001", "掌握", "30");
        Subject s4 = new Subject("003", "一般", "50");
        List<Subject> subjectList = Arrays.asList(s1, s2, s3, s4);
        Map<String, String> map = new HashMap<>();
        for (Subject subject : subjectList) {
            String code = subject.getCode();
            String value = subject.getLevelName() + subject.getPercentAge() + "%;";
            if (!map.containsKey(code)) {
                map.put(code, value);
            } else {
                String s = map.get(code);
                map.put(code, s + value);
            }
        }

        System.out.println(map);

    }


}
