package com.touchsun.autumn.core.test;

import com.touchsun.autumn.core.bean.BeanFactory;
import com.touchsun.autumn.core.test.service.UserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * 简单测试
 *
 * @author lee
 * @since 2022/12/19 14:31
 */
public class SimpleTest {

    /**
     * >>
     * 测试获取一个Bean对象
     */
    @Test
    public void testGetBean() {
        // 实例化Bean工厂
        BeanFactory beanFactory = new BeanFactory();
        // 注册一个Bean对象
        beanFactory.register("userService", new UserService());
        // 获取一个Bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        // 断言
        Assert.assertNotNull(userService);
        Assert.assertEquals(userService.info(), "TouchSun");
    }
    
}










