package com.tomcat.beta.设计模式.单例模式;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程间单例
 * Create by yuzhangbin on 2020/9/17
 */
public class IdGeneratorV6 {
    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long,IdGeneratorV6> instance = new ConcurrentHashMap<Long,IdGeneratorV6>();

    private IdGeneratorV6() {

    }

    public static IdGeneratorV6 getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instance.putIfAbsent(currentThreadId,new IdGeneratorV6());
        return instance.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
