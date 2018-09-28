package com.i2bgod.test;

import com.i2bgod.test.service.Hello;
import com.i2bgod.test.service.IHello;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
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
}
