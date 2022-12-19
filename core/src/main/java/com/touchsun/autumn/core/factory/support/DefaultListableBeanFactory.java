package com.touchsun.autumn.core.factory.support;

import cn.hutool.core.text.StrFormatter;
import com.touchsun.autumn.core.factory.config.BeanDefinition;
import com.touchsun.autumn.exceptions.BeanException;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认可列出的 Bean 工厂
 * 给出了注册Bean定义及获取Bean定义的具体实现 
 *
 * @author lee
 * @since 2022/12/19 15:20
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * Bean 信息容器
     */
    private Map<String, BeanDefinition> beanDefinitionContainer = new HashMap<>();
    
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeanException {
        // 尝试从容器内获取Bean定义
        BeanDefinition beanDefinition = beanDefinitionContainer.get(beanName);
        // 没有Bean定义则抛出Bean未定义异常
        if (beanDefinition == null) {
            throw new BeanException(StrFormatter.format("名称为：{}的Bean没有被定义", beanName));
        }
        // 返回Bean定义
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionContainer.put(beanName, beanDefinition);
    }
}












