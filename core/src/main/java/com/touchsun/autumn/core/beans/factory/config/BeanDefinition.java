package com.touchsun.autumn.core.beans.factory.config;

import com.touchsun.autumn.core.beans.PropertyValues;

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

    /**
     * Bean的属性信息
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
