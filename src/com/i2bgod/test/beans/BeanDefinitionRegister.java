package com.i2bgod.test.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: Lyn
 * @data: 2018/9/29
 */
public class BeanDefinitionRegister {
    private final Map<String, BeanDefinition> DEFINITIONS = new ConcurrentHashMap<>();

    public void registerBeanDefinition(String beanName, BeanDefinition bd) {
        if (DEFINITIONS.containsKey(beanName)) {
            throw new RuntimeException("bean exist");
        }
        DEFINITIONS.put(beanName, bd);
    }

    public BeanDefinition getBeanDefinition(String beanName) {
       return DEFINITIONS.get(beanName);
    }

    public boolean containsBeanDefinition(String beanName) {
       return DEFINITIONS.containsKey(beanName);
    }

}
