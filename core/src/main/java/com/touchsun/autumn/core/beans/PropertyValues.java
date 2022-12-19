package com.touchsun.autumn.core.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Bean 属性信息集
 *
 * @author lee
 * @since 2022/12/19 17:34
 */
public class PropertyValues {

    /**
     * 属性列表
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加bean属性信息
     * 
     * @param propertyValue Bean属性信息
     */
    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    /**
     * @return 以Bean属性信息组成的数组结构
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }
    
    /**
     * 获取bean属性信息
     * 
     * @param propertyName 属性名称
     * @return 属性对象
     */
    public PropertyValue getPropertyValue(String propertyName) {
        Predicate<PropertyValue> findName = v -> v.getName().equals(propertyName);
        return propertyValueList.stream().filter(findName).collect(Collectors.toList()).iterator().next();
    }
}
