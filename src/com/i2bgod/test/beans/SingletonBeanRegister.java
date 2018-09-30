package com.i2bgod.test.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: Lyn
 * @data: 2018/9/29
 */
public class SingletonBeanRegister {
    private final Map<String, Object> BEANS = new ConcurrentHashMap<>();

    public boolean containsSingleton(String beanName) {
        return BEANS.containsKey(beanName);
    }

    public Object getSingleton(String beanName) {
        return BEANS.get(beanName);
    }

    public int getSingletonCount() {
        return BEANS.size();
    }

    public String[] getSingletonNames() {
        return BEANS.keySet().toArray(new String[0]);
    }

    public void registerSingleton(String beanName, Object bean) {
        if (BEANS.containsKey(beanName)) {
            throw new RuntimeException("exist bean");
        }
        BEANS.put(beanName, bean);
    }
}
