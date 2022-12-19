package com.touchsun.autumn.core.beans.factory.support;

import com.touchsun.autumn.core.beans.factory.config.BeanDefinition;
import com.touchsun.autumn.core.beans.exceptions.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 基于Cglib动态代理的实例化策略
 *
 * @author lee
 * @since 2022/12/19 16:00
 */
public class CglibInstantiationStrategy implements InstantiationStrategy {
    
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback( (MethodInterceptor) (obj, method, argsTemp, proxy) -> proxy.invokeSuper(obj, argsTemp));
        return enhancer.create();
    }
}
