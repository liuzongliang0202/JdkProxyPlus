/*
 * File Name:com.lzl.test.TargetClass is created on 2021/7/16 10:39 上午 by liuzongliang
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.lzl.test;

/**
 * @author liuzongliang
 * @Description 目标类
 * @date: 2021/7/16 10:39 上午
 * @since JDK 1.8
 */
public class TargetClass {
    public int xx = 10;
    public String targetValue(String title){
        System.out.println("target "+title);
        return "ok";
    }
}
