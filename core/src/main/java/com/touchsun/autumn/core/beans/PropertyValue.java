package com.touchsun.autumn.core.beans;

/**
 * Bean 属性信息
 *
 * @author lee
 * @since 2022/12/19 17:33
 */
public class PropertyValue {

    /**
     * Bean名称
     */
    private final String name;

    /**
     * Bean对象
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
