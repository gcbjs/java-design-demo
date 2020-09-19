package com.tomcat.beta.设计模式.单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类
 * 这种实现方法既保证了线程安全，又能做到延迟加载。
 * Create by yuzhangbin on 2020/9/17
 */
public class IdGeneratorV4 {
    private AtomicLong id = new AtomicLong(0);
    private IdGeneratorV4() {

    }

    private static class SingletonHolder {
        private static final IdGeneratorV4 instance = new IdGeneratorV4();
    }

    public static IdGeneratorV4 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
