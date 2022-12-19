package com.touchsun.autumn.core.factory.support;

import com.touchsun.autumn.core.factory.config.BeanDefinition;

/**
 * Bean 定义注册表
 *
 * @author lee
 * @since 2022/12/19 15:07
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册Bean信息
     * 
     * @param beanName Bean名称
     * @param beanDefinition Bean信息
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
