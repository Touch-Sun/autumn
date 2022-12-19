package com.touchsun.autumn.core.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.StrFormatter;
import com.touchsun.autumn.core.beans.PropertyValue;
import com.touchsun.autumn.core.beans.factory.config.BeanDefinition;
import com.touchsun.autumn.core.beans.exceptions.BeansException;

/**
 * 具有抽象自动装配功能的 Bean 工厂
 *
 * @author lee
 * @since 2022/12/19 15:09
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 实例化策略
     * 默认简单策略
     */
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

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
    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        // 获取Bean的类路径
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 准备对象
        Object bean;
        // 创建对象
        try {
            // 根据策略进行实例化
            bean = createBeanInstance(beanDefinition);
            // 设置Bean的属性信息
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException(StrFormatter.format("实例化Bean[{}]失败...", beanClass.getName()), e);
        }
        // 添加到单例Bean容器
        putSingletonBean(beanName, bean);
        return bean;
    }
    
    protected Object createBeanInstance(BeanDefinition beanDefinition) {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    /**
     * 给Bean填充属性信息
     * 
     * @param beanName Bean名称
     * @param bean Bean对象
     * @param beanDefinition Bean定义(包含属性信息)
     */
    public void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            // 遍历Bean定义中配置的属性
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                // 属性名
                String name = propertyValue.getName();
                // 属性值
                Object value = propertyValue.getValue();
                // 设置属性
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException(StrFormatter.format("给Bean：{}设置属性时发生错误", beanName), e);
        }
    }
}














