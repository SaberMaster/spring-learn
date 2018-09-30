package com.i2bgod.test.beans;

import org.junit.Test;

/**
 * @auther: Lyn
 * @data: 2018/9/29
 */
public class BeanTest {
    @Test
    public void testSingleton() {
        DefaultBeanFactory bf = new DefaultBeanFactory();
        BeanDefinition bd = new BeanDefinition();
        bd.setId("test");
        bd.setClazz("com.i2bgod.test.beans.Hello");
        bd.setSCOPE(BeanDefinition.SCOPE_SINGLETON);
        bf.registerBeanDefinition(bd);
        System.out.println(bf.getBean("test") == bf.getBean("test"));
    }

    @Test
    public void testPrototype() {
        DefaultBeanFactory bf = new DefaultBeanFactory();
        BeanDefinition bd = new BeanDefinition();
        bd.setId("test");
        bd.setClazz("com.i2bgod.test.beans.Hello");
        bd.setSCOPE(BeanDefinition.SCOPE_PROTOTYPE);
        bf.registerBeanDefinition(bd);
        System.out.println(bf.getBean("test") == bf.getBean("test"));
    }
}
