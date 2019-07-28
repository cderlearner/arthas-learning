package com.xing.arthas.demo;

import java.util.concurrent.TimeUnit;

public class FooMain {
    public static void main(String[] args) throws Exception{
        for (;;) {
            System.out.println(new Foo().getDesc());
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
