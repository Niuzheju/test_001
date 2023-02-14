package com.niuzj.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author niuzheju
 * @date 15:39 2021/8/17
 */
public class Test15 {

    @Test
    public void test01() throws InterruptedException {
        User u1 = new User(1, "java");
        User u2 = new User(2, "php");
        User u3 = new User(1, "html");
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(User::getType));
        Map<Integer, List<String>> map1 = new HashMap<>(map.size());
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            List<String> list1 = entry.getValue().stream().map(User::getCode).collect(Collectors.toList());
            map1.put(entry.getKey(), list1);
        }
        System.out.println(map1);

        Map<Integer, List<String>> map2 = new HashMap<>();
        for (User user : list) {
            List<String> stringList = map2.computeIfAbsent(user.getType(), k -> new ArrayList<>());
            stringList.add(user.getCode());
        }
        System.out.println(map2);
    }

    @Test
    public void test02() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "php");
        String s = map.computeIfPresent(1, (k, v) -> "java");
        System.out.println(s);
        System.out.println(map);
    }

    @Test
    public void test03() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "php");
        String s = map.computeIfAbsent(2, k -> "java");
        System.out.println(s);
        System.out.println(map);
    }

    @Test
    public void test04() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "php");
        String s = map.putIfAbsent(2, "java");
        System.out.println(s);
        System.out.println(map);
    }

    private static class User {

        private int type;
        private String code;

        public User(int type, String code) {
            this.type = type;
            this.code = code;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }


}
