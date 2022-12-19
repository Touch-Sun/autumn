package com.touchsun.autumn.core.factory.config;

/**
 * Bean 定义
 *
 * @author lee
 * @since 2022/12/19 14:49
 */
public class BeanDefinition {

    /**
     * Bean的class路径
     */
    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
