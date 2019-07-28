package com.xing.arthas.demo;

public class Foo {
    private String desc = "fix";

    public String getDesc() {
        System.out.println("ClassLoader:" + this.getClass().getClassLoader());
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
