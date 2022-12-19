package com.touchsun.autumn.core.factory.config;

/**
 * 单例注册表
 *
 * @author lee
 * @since 2022/12/19 14:50
 */
public interface SingletonBeanRegistry {

    /**
     * 获取一个单例Bean对象
     * 
     * @param beanName Bean名称
     * @return Bean对象
     */
    Object getSingletonBean(String beanName);
}
