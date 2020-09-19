package com.tomcat.beta.设计模式.单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举
 * 保证了实例创建的线程安全性和实例的唯一性
 * Create by yuzhangbin on 2020/9/17
 */
public enum IdGeneratorV5 {

    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
