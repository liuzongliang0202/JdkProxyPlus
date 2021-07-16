/*
 * File Name:com.lzl.test.MyInvoker is created on 2021/7/16 10:45 上午 by liuzongliang
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.lzl.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author liuzongliang
 * @Description 方法调用拦截器
 * @date: 2021/7/16 10:45 上午
 * @since JDK 1.8
 */
public class MyInvoker implements InvocationHandler {
    private Object target;

    public MyInvoker() {
    }

    public MyInvoker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy call " + method.getName());
        if (target != null) {
            Method[] declaredMethods = target.getClass().getDeclaredMethods();
            if (declaredMethods.length > 0 && Arrays.asList(declaredMethods).contains(method)) {
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        }
        return null;
    }
}
