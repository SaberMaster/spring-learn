package com.i2bgod.test.service.impl;

import com.i2bgod.test.service.IHello;

/**
 * @auther: Lyn
 * @data: 2018/9/28
 */
public class Hello implements IHello {

    private String msg;

    public Hello(String msg) {
        this.msg = msg;
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }

    @Override
    public void sayMsg() {

        System.out.println(msg);
    }
}
