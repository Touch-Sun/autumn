package com.touchsun.autumn.core.beans.factory.support;

import com.touchsun.autumn.core.beans.factory.config.BeanDefinition;
import com.touchsun.autumn.core.beans.exceptions.BeansException;

/**
 * Bean 的实例化策略
 *
 * @author lee
 * @since 2022/12/19 15:47
 */
public interface InstantiationStrategy {

    /**
     * 实例化
     * 
     * @param beanDefinition Bean定义
     * @return Bean对象
     * @throws BeansException 实例化Bean失败异常
     */
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
