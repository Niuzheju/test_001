package com.niuzj.model;

/**
 * @author niuzheju
 * @date 16:51 2021/8/16
 */
public class TestSon extends TestParent {

    private int i;

    public TestSon() {
        i = 1;
    }

    @Override
    public void pushinfo() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        new TestSon().invoke();
    }
}
