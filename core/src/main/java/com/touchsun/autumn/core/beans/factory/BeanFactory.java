package com.touchsun.autumn.core.beans.factory;

import com.touchsun.autumn.core.beans.exceptions.BeansException;

/**
 * Bean工厂
 *
 * @author lee
 * @since 2022/12/19 14:25
 */
public interface BeanFactory {

    /**
     * 获取Bean对象
     * 
     * @param beanName Bean名称
     * @return Bean对象
     * @throws BeansException Bean实例化失败异常
     */
    Object getBean(String beanName) throws BeansException;
}
