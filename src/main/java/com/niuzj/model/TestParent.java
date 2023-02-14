package com.niuzj.model;

/**
 * @author niuzheju
 * @date 16:50 2021/8/16
 */
public abstract class TestParent {

    public TestParent() {
        pushinfo();
    }

    public void invoke() {
        pushinfo();
    }

    protected abstract void pushinfo();


}
