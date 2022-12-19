package com.touchsun.autumn.core.beans;

import com.touchsun.autumn.core.beans.factory.config.BeanDefinition;
import com.touchsun.autumn.core.beans.factory.support.DefaultListableBeanFactory;
import com.touchsun.autumn.core.pojo.User;
import org.junit.Test;

import java.time.Period;

/**
 * 属性值设置测试
 *
 * @author lee
 * @since 2022/12/19 17:52
 */
public class PropertyValuesTest {
    
    @Test
    public void testProperty() {
        // 实例化默认可列出的 Bean 工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 配置属性
        PropertyValues propertyValues = new PropertyValues();
        // 添加属性
        propertyValues.addPropertyValue(new PropertyValue("username", "TouchSun"));
        propertyValues.addPropertyValue(new PropertyValue("password", "123456"));
        // 创建Bean定义并装载属性配置
        BeanDefinition userDefined = new BeanDefinition(User.class, propertyValues);
        // 注册Bean对象User
        beanFactory.registerBeanDefinition("user", userDefined);

        for (int i = 0; i < 100; i++) {
            // 获取Bean
            User user = (User) beanFactory.getBean("user");
            System.out.println(user.toString());
        }
    }
}












