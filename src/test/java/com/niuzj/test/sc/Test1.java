package com.niuzj.test.sc;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author niuzheju
 * @Date 15:08 2023/2/13
 */
public class Test1 {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        for (Integer integer : list) {
            list.remove(integer);
        }

        System.out.println(list);
    }

    @Test
    public void test02() {

        System.out.println(65537 & 15);
    }

    @Test
    public void test03(){
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        System.out.println(vector);

        CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>();
        list1.add(1);
        list1.add(2);
        System.out.println(list1);

        CopyOnWriteArraySet<Integer> set1 = new CopyOnWriteArraySet<>();
        set1.add(1);
        set1.add(2);
        System.out.println(set1);

        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        list2.add("xxx");
        list2.add("yyy");
        System.out.println(list2);

        Set<String> set2 = Collections.synchronizedSet(new HashSet<>());
        set2.add("xxx");
        set2.add("yyy");
        System.out.println(set2);

        ConcurrentHashMap<String, String> map1 =  new ConcurrentHashMap<>();
        map1.put("name", "nzj");
        map1.put("age", "18");
        System.out.println(map1);

        Map<String, String> map2 = Collections.synchronizedMap(new HashMap<>());
        map2.put("name", "nzj");
        map2.put("age", "18");
        System.out.println(map2);
    }


}
