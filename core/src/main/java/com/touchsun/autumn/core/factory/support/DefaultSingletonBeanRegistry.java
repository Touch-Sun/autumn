package com.touchsun.autumn.core.factory.support;

import com.touchsun.autumn.core.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例 Bean 注册表
 *
 * @author lee
 * @since 2022/12/19 14:53
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 单例Bean容器
     */
    private Map<String, Object> singletonBeanContainer = new HashMap<>();
    
    @Override
    public Object getSingletonBean(String beanName) {
        return singletonBeanContainer.get(beanName);
    }

    /**
     * 添加一个单例Bean对象
     * 
     * @param beanName Bean名称
     * @param singletonBean Bean对象
     */
    public void putSingletonBean(String beanName, Object singletonBean) {
        singletonBeanContainer.put(beanName, singletonBean);
    }
}
