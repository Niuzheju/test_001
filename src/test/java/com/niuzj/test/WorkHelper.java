package com.niuzj.test;

import com.niuzj.tools.HttpClientUtil;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * @author niuzheju
 * @date 16:19 2021/11/23
 */
public class WorkHelper {

    @Test
    public void test01() throws IOException {
        final String mappingFile = "sys_template_mapping.json";

        String deleteUrl = "http://elastic:n712Q7y05UzbPCxWBNn3646A@es.k8s.hecaila.com:9200/sys_templates?pretty";
        String delete = HttpClientUtil.delete(deleteUrl);
        System.out.println(delete);

        String createUrl = "http://elastic:n712Q7y05UzbPCxWBNn3646A@es.k8s.hecaila.com:9200/sys_templates/_doc?pretty";
        String post = HttpClientUtil.post(createUrl, "{}");
        System.out.println(post);

        String putUrl = "http://elastic:n712Q7y05UzbPCxWBNn3646A@es.k8s.hecaila.com:9200/sys_templates/_mapping?pretty";
        String mapping = IOUtils.toString(Objects.requireNonNull(new ClassPathResource(mappingFile).getInputStream()), Charset.defaultCharset());
        String put = HttpClientUtil.put(putUrl, mapping);
        System.out.println(put);
    }


    @Test
    public void test02() throws IOException {
        InputStream stream = WorkHelper.class.getResourceAsStream("/sys_template_mapping.json");
        System.out.println(IOUtils.toString(Objects.requireNonNull(stream), Charset.defaultCharset()));
    }
}
