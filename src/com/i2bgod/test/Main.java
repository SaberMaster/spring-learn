package com.i2bgod.test;

import com.i2bgod.test.service.IHello;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    @Test
    public void getBeanByClass() {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IHello hello = applicationContext.getBean(IHello.class);
        hello.hello();
    }

    @Test
    public void initConstructor() {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("constructor-init.xml");
        IHello hello = applicationContext.getBean(IHello.class);
        hello.sayMsg();
    }

    @Test
    public void initStaticFactory() {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("static-factory-init.xml");
        IHello hello = applicationContext.getBean(IHello.class);
        hello.sayMsg();
    }

    @Test
    public void initFactory() {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("factory-init.xml");
        IHello hello = applicationContext.getBean("hello", IHello.class);
        hello.sayMsg();
    }
}
