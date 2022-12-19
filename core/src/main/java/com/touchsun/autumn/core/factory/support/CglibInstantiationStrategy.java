package com.touchsun.autumn.core.factory.support;

import com.touchsun.autumn.core.factory.config.BeanDefinition;
import com.touchsun.autumn.exceptions.BeanException;
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
    public Object instantiate(BeanDefinition beanDefinition) throws BeanException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback( (MethodInterceptor) (obj, method, argsTemp, proxy) -> proxy.invokeSuper(obj, argsTemp));
        return enhancer.create();
    }
}
