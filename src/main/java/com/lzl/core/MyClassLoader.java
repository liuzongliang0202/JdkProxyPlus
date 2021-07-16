/*
 * File Name:com.lzl.core.MyClassLoader is created on 2021/7/16 10:35 上午 by liuzongliang
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.lzl.core;

/**
 * @author liuzongliang
 * @Description 自定义类加载器
 * @date: 2021/7/16 10:35 上午
 * @since JDK 1.8
 */
public class MyClassLoader extends ClassLoader{
    private final byte[] bytes;

    public MyClassLoader(byte[] bytes){
        this.bytes = bytes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return defineClass(name,bytes, 0, bytes.length);
    }
}
