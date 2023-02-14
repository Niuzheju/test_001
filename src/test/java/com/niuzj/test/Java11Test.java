package com.niuzj.test;

import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author niuzheju
 * @date 14:34 2020/9/18
 */
public class Java11Test {

    /**
     * HttpClient
     */
    @Test
    public void test01() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/"))
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    /**
     * 自动类型var
     */
    @Test
    public void test02() {
        var name = 1.1;
        System.out.println(name);
    }
}
