package com.tomcat.beta.设计模式.单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检测
 * 存在问题：
 * 因为指令重排序，可能会导致 IdGenerator 对象被 new 出来，
 * 并且赋值给 instance 之后，还没来得及初始化(执行构造函数中的代码逻辑)，就被另一个线程使用了。
 *
 * 解决方案：
 * instance 加volatile关键字，禁止指令重排序才行。
 *
 * Create by yuzhangbin on 2020/9/17
 */
public class IdGeneratorV3 {
    private AtomicLong id = new AtomicLong(0);
    private static volatile IdGeneratorV3 instance;
    private IdGeneratorV3(){}
    public static IdGeneratorV3 getInstance() {
        if (instance == null) {
            synchronized(IdGeneratorV3.class) {
                if (instance == null) {
                    instance = new IdGeneratorV3();
                }
            }
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}
