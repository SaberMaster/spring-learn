package com.i2bgod.test.beans;

/**
 * @auther: Lyn
 * @data: 2018/9/29
 */
public class DefaultBeanFactory {
   private final BeanDefinitionRegister DEFINITIONS = new BeanDefinitionRegister();
   private final SingletonBeanRegister SINGLETONS = new SingletonBeanRegister();

   public Object getBean(String beanName) {
      if (!DEFINITIONS.containsBeanDefinition(beanName)) {
         throw new RuntimeException("bean define not exists");
      }
      BeanDefinition bd = DEFINITIONS.getBeanDefinition(beanName);

      if (bd.getSCOPE() == BeanDefinition.SCOPE_SINGLETON) {
        if (!SINGLETONS.containsSingleton(beanName)) {
            SINGLETONS.registerSingleton(beanName, createBean(bd));
        }
        return SINGLETONS.getSingleton(beanName);
      }

      if (bd.getSCOPE() == BeanDefinition.SCOPE_PROTOTYPE) {
          return createBean(bd);
      }

      throw new RuntimeException("not valid bean");
   }

   public void registerBeanDefinition(BeanDefinition bd) {
       DEFINITIONS.registerBeanDefinition(bd.getId(), bd);
   }


    private Object createBean(BeanDefinition bd) {
       try {
           Class<?> clz = Class.forName(bd.getClazz());
           return clz.getConstructor().newInstance();
       } catch (ClassNotFoundException e) {
           throw new RuntimeException("not find bean class");
       } catch (Exception e) {
           throw new RuntimeException("create bean fail");
       }
    }
}
