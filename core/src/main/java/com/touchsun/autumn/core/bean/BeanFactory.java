package com.touchsun.autumn.core.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Bean工厂
 *
 * @author lee
 * @since 2022/12/19 14:25
 */
public class BeanFactory {

    /**
     * Bean容器
     */
    private Map<String, Object> beanContainer = new HashMap<>();

    /**
     * 注册Bean
     * 
     * @param name Bean名称
     * @param bean Bean对象
     */
    public void register(String name, Object bean) {
        beanContainer.put(name, bean);
    }

    /**
     * 获取Bean对象
     * 
     * @param name Bean名称
     * @return Bean对象
     */
    public Object getBean(String name) {
        return beanContainer.get(name);
    }
}
