package com.niuzj.model;

public class Parent {
    protected int count;
}

class Son extends Parent{

    private int number;

    /**
     * this既能访问自己的属性也能访问到父类的属性
     */
    public Son() {
        this.count = 1;
        System.out.println(this.number);
        System.out.println(this.count);
    }

    public static void main(String[] args) {
        new Son();

    }
}

