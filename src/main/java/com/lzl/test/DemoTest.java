/*
 * File Name:com.lzl.test.DemoTest is created on 2021/7/16 10:38 上午 by liuzongliang
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.lzl.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

import com.lzl.core.MyClassLoader;
import com.lzl.core.MyProxyGenerator;

/**
 * @author liuzongliang
 * @Description
 * @date: 2021/7/16 10:38 上午
 * @since JDK 1.8
 */
public class DemoTest {
    public static void main(String[] args) throws Exception {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        final String className = "DemoProxy";
        byte[] bytes = MyProxyGenerator
            .generateProxyClass(className, new Class[] {HelloInterface.class}, TargetClass.class.getName());
        MyClassLoader classLoader = new MyClassLoader(bytes);
        Class<?> clazz = classLoader.loadClass(className);
        Constructor<?> constructor = clazz.getConstructor(InvocationHandler.class);
        Object instance = constructor.newInstance(new MyInvoker(new TargetClass()));
        TargetClass targetClass = (TargetClass)instance;
        targetClass.targetValue("999");
        HelloInterface helloInterface = (HelloInterface)instance;
        helloInterface.hello("kkk");
    }
}
