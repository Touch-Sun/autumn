package com.touchsun.autumn.core.factory.support;

import cn.hutool.core.text.StrFormatter;
import com.touchsun.autumn.core.factory.config.BeanDefinition;
import com.touchsun.autumn.exceptions.BeanException;

import java.lang.reflect.Constructor;

/**
 * 基于对象构造器的实例化策略
 *
 * @author lee
 * @since 2022/12/19 15:49
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeanException {
        // 获取Bean的类路径
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 实例化
        try {
            // 获取构造器
            Constructor<?> constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeanException(StrFormatter.format("实例化Bean[{}]失败...", beanClass.getName()), e);
        }
    }
}
