package com.tomcat.beta.设计模式.单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 * 如果频繁地用到，那频繁加锁、释放锁及并发度低 等问题，会导致性能瓶颈
 * Create by yuzhangbin on 2020/9/17
 */
public class IdGeneratorV2 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV2 instance;
    private IdGeneratorV2(){}
    public static synchronized IdGeneratorV2 getInstance() {
        if (instance == null) {
            instance = new IdGeneratorV2();
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}
