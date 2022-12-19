package com.touchsun.autumn.core.beans.factory.support;

import com.touchsun.autumn.core.beans.factory.BeanFactory;
import com.touchsun.autumn.core.beans.factory.config.BeanDefinition;
import com.touchsun.autumn.core.beans.exceptions.BeansException;

/**
 * 抽象 Bean 工厂
 *
 * @author lee
 * @since 2022/12/19 14:59
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    
    @Override
    public Object getBean(String beanName) throws BeansException {
        // 先通过超类获取Bean对象
        Object bean = getSingletonBean(beanName);
        
        if (bean != null) {
            return bean;
        }
        
        // 获取Bean信息
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        // 创建Bean对象
        return createBean(beanName, beanDefinition);
    }

    /**
     * 创建Bean对象
     * 
     * @param beanName Bean名称
     * @param beanDefinition Bean信息
     * @return Bean对象
     * @throws BeansException Bean实例化失败异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    /**
     * 获取Bean信息
     * 
     * @param beanName Bean名称
     * @return Bean信息
     * @throws BeansException Bean没有定义异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
