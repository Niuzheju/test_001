package com.niuzj.test;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author niuzheju
 * @date 16:26 2021/7/2
 */
public class Test13 {

    public void test01() {

        String url = "https://batch-tools.k8s.hecaila.com/api/cutout";
        File file = new File("E:\\Desktop\\640.webp");
        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjIxODg5ODcsImV4cCI6MTY1MzI5Mjk4NywidXNlcklkIjoiMyIsIm1vYmlsZSI6IjEzMDE4OTcwMTA2Iiwicm9sZSI6IlVTRVIifQ.WGrQIc1I8cm9TWyfoi4W67FHVbDqTBBif1Kt0b-CvTg";

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

        HttpPost post = new HttpPost(url);
        post.addHeader("Authorization", token);

        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
        multipartEntityBuilder.addBinaryBody("images", file, ContentType.MULTIPART_FORM_DATA, file.getName());
        multipartEntityBuilder.addBinaryBody("images", file, ContentType.MULTIPART_FORM_DATA, file.getName());

        post.setEntity(multipartEntityBuilder.build());

        long start = System.currentTimeMillis();
        String s = "";
        try {
            CloseableHttpResponse response = client.execute(post);

            System.out.println(Thread.currentThread().getName() + " cost " + (System.currentTimeMillis() - start) + " ms");

            s = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    @Test
    public void test02() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10,
                20, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

        int num = 1;
        for (int i = 0; i < num; i++) {
            executorService.submit(this::test01);
        }

        TimeUnit.SECONDS.sleep(1800);


    }

    @Test
    public void test03() {
        String s = "java,js,python,html";
        StringTokenizer tokenizer = new StringTokenizer(s, ",");
        while (tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }

    }
}
