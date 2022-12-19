package com.touchsun.autumn.core.factory.support;

import cn.hutool.core.text.StrFormatter;
import com.touchsun.autumn.core.factory.config.BeanDefinition;
import com.touchsun.autumn.exceptions.BeanException;

/**
 * 具有抽象自动装配功能的 Bean 工厂
 *
 * @author lee
 * @since 2022/12/19 15:09
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    /**
     * 创建Bean对象根据Bean定义
     * 
     * @param beanName Bean名称
     * @param beanDefinition Bean定义
     * @return Bean对象
     */
    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        // 获取Bean的类路径
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 准备对象
        Object bean;
        // 创建对象
        try {
            bean = beanClass.newInstance();
        } catch (Exception e) {
            throw new BeanException(StrFormatter.format("实例化Bean[{}]失败...", beanClass.getName()), e);
        }
        // 添加到单例Bean容器
        putSingletonBean(beanName, bean);
        return bean;
    }
}














