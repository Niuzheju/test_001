package com.niuzj.test;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;
import org.junit.Test;

/**
 * @author niuzheju
 * @date 17:20 2020/10/22
 */
public class JsonSmartTest {

    @Test
    public void test01(){
        JSONObject obj = new JSONObject();
        obj.put("name", "nzj");
        obj.put("age", "10");
        System.out.println(obj.toJSONString(JSONStyle.LT_COMPRESS));
    }
}
