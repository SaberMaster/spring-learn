package com.i2bgod.test.service;

import com.i2bgod.test.service.impl.Hello;

/**
 * @auther: Lyn
 * @data: 2018/9/28
 */
public class IHelloFactory {
    public IHello newInstance(String msg) {
       return new Hello(msg);
    }
}
