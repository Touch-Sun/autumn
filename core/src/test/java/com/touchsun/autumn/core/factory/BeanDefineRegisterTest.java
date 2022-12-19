package com.touchsun.autumn.core.factory;

import com.touchsun.autumn.core.beans.factory.config.BeanDefinition;
import com.touchsun.autumn.core.beans.factory.support.CglibInstantiationStrategy;
import com.touchsun.autumn.core.beans.factory.support.DefaultListableBeanFactory;
import com.touchsun.autumn.core.service.UserService;
import org.junit.Test;

/**
 * Bean的定义和注册测试
 *
 * @author lee
 * @since 2022/12/19 15:33
 */
public class BeanDefineRegisterTest {
    
    @Test
    public void testBeanFactory() {
        // 实例化默认可列出的 Bean 工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建一个Bean定义
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        // 注册Bean定义
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 设置Bean实例化策略
        beanFactory.setInstantiationStrategy(new CglibInstantiationStrategy());

        for (int i = 0; i < 100; i++) {
            // 获取Bean并且执行方法
            UserService userService = (UserService) beanFactory.getBean("userService");
            System.out.println(userService);
        }
    }
}
