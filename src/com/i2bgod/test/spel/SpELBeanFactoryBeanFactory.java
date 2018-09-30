package com.i2bgod.test.spel;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;

/**
 * @auther: Lyn
 * @data: 2018/9/30
 */
public class SpELBeanFactoryBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        StandardBeanExpressionResolver resolver = (StandardBeanExpressionResolver) beanFactory.getBeanExpressionResolver();
        resolver.setExpressionPrefix("%{");
        resolver.setExpressionSuffix("}");
    }
}
