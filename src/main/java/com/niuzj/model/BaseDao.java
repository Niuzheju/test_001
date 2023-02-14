package com.niuzj.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author niuzheju
 * @date 15:07 2021/1/19
 */
public class BaseDao<T> {

    private static final ObjectMapper om =
            new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    protected T t;

    public void testType(String json) throws JsonProcessingException {
        Object value1 = om.readValue(json, t.getClass());
        T value2 = om.readValue(json, new TypeReference<>() {
        });
        System.out.println(value1);

    }

    public void setT(T t) {
        this.t = t;
    }
}
