package com.niuzj.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: niuzheju
 * @Date: 14:10  2020/6/19
 */
public class Test10 {

    @Test
    public void test(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "nzj");
        Object json = JSON.toJSON(map);
        System.out.println(json);

    }
}
