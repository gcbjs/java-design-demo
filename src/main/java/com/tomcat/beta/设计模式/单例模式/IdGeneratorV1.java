package com.tomcat.beta.设计模式.单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 * 反对意见：不支持延迟加载
 * 赞同意见：如果实例占用资源多，按照 fail-fast 的设计原则(有问题及早暴露)，
 * 那我们也希望在程 序启动时就将这个实例初始化好。
 * 如果资源不够，就会在程序启动的时候触发报错(比如 Java 中的 PermGen Space OOM)，我们可以立即去修复
 * Create by yuzhangbin on 2020/9/17
 */
public class IdGeneratorV1 {
    private AtomicLong id = new AtomicLong(0);

    private static final IdGeneratorV1 instance = new IdGeneratorV1();

    private IdGeneratorV1() {

    }

    public static IdGeneratorV1 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
