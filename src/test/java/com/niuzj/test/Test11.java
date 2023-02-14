package com.niuzj.test;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: niuzheju
 * @Date: 16:33  2020/6/22
 */
public class Test11 {

    //2020      18
    @Test
    public void test01() {
        SnowFlakeIdGenerator generator = new SnowFlakeIdGenerator(2, 3);
        for (int i = 2020; i <= 2030; i++) {
            Calendar cal = Calendar.getInstance();
            cal.set(i, Calendar.JUNE, 22);
            long l = cal.getTimeInMillis();
            System.out.println(String.valueOf(generator.nextId(l)).length());
        }
    }

    @Test
    public void test02() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test03() {
        System.out.println(null instanceof Integer);
    }

    @Test
    public void test04() {
        Map<String, String> map = new HashMap<>(1);
        map.put("name", "test");
        System.out.println(map);
    }

    @Test
    public void test05(){
        String s = "<form name=\\\"punchout_form\\\" method=\\\"post\\\" action=\\\"https://openapi.alipaydev.com/gateway.do?charset=utf-8&method=alipay.trade.page.pay&sign=SZJFiREpKSSkSGXwdB7zWgOrAhBwpuxJUbsWHC0k2x%2ByuSx2f0iG38U9Vsz%2BssGwZtqdTOcXndiZCWrdi4JfrslVEP7IX9G8MyzHPDpJ%2F1NGuJTLTDWSoVAqS6p5SRsPslQTV3Wnt8Xaowl9vF%2Fsgrq3gGk5N7QdAh5VxOMXTFAHoiP9qpeVyYjqMSV%2FN8IanTefY7G5P1jPibgQZ0kMl6sXIyRUXXgXkagif5YPeczb5kFqLNqo8n395pqu%2BE7lGZQ8EIWbk1mBD65jh5IW9dAKiMXBM5wG%2F%2Fn2k0Zz2vOBmIHA6IDmiA5eKnFFntyVCnPW4LjOQkeixUx4lRwGbQ%3D%3D&return_url=https%3A%2F%2Fec.test0.bravo-ink.com%2Fpayment%2Fsuccess&notify_url=https%3A%2F%2Fec.test0.bravo-ink.com%2Fapi%2Falipay%2Fnotify&version=1.0&app_id=2016101300672734&sign_type=RSA2&timestamp=2020-07-29+16%3A11%3A14&alipay_sdk=alipay-sdk-java-4.8.10.ALL&format=json\\\">\\n<input type=\\\"hidden\\\" name=\\\"biz_content\\\" value=\\\"{&quot;out_trade_no&quot;:&quot;1111111123&quot;,&quot;total_amount&quot;:&quot;20.99&quot;,&quot;subject&quot;:&quot;商品一&quot;,&quot;body&quot;:&quot;商品一的描述&quot;,&quot;timeout_express&quot;:&quot;30m&quot;,&quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;}\\\">\\n<input type=\\\"submit\\\" value=\\\"立即支付\\\" style=\\\"display:none\\\" >\\n</form>\\n<script>document.forms[0].submit();</script>";
        System.out.println(s);
        System.out.println(s.replace("\\\"", "\""));

    }
}
