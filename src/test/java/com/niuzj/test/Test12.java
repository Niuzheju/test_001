package com.niuzj.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.niuzj.model.AliPay;
import com.niuzj.model.BaseDao;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author niuzheju
 * @date 15:20 2021/1/19
 */
public class Test12 {

    @Test
    public void test01() throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("app_auth_token", "token");
        jsonObject.put("app_id", "001");
        jsonObject.put("version", 100);
        String s = jsonObject.toJSONString();
        BaseDao<AliPay> baseDao = new BaseDao<>();
        baseDao.setT(new AliPay());
        baseDao.testType(s);
    }

    @Test
    public void test02(){
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("uuuu-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("YYYY-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 26);
        System.out.println(dateFormat1.format(cal.getTime()));
        System.out.println(dateFormat2.format(cal.getTime()));
        System.out.println("=================================");
        cal.set(Calendar.DATE, 28);
        System.out.println(dateFormat1.format(cal.getTime()));
        System.out.println(dateFormat2.format(cal.getTime()));

    }

    @Test
    public void test03(){
        AliPay aliPay = new AliPay();
        aliPay.setVersion(1);
        aliPay.setAppAuthToken("token");
        aliPay.setAppId("001");
        String s = JSON.toJSONString(aliPay, SerializerFeature.WriteClassName);
        System.out.println(s);
    }

    @Test
    public void test04(){
        Set<String> set = new TreeSet<>();
        set.add("ac111");
        set.add("ac");
        set.add("bc");
        System.out.println(set);

    }
}
