package com.tomcat.beta.设计模式.建造者模式;

/**
 * 非原型模式
 */
public class ResourcePoolConfig {

    private static final int DEFAULT_MAX_TOTAL = 8;

    private static final int DEFAULT_MAX_IDLE = 8;

    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;

    private int maxTotal = DEFAULT_MAX_TOTAL;

    private int maxIdle = DEFAULT_MAX_IDLE;

    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
        if (maxTotal !=null) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("macTotal should be positive");
            }
            this.maxTotal = maxTotal;
        }
        if(maxIdle !=null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should be positive");
            }
            this.maxIdle = maxIdle;
        }

        if(minIdle !=null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should be positive");
            }
            this.minIdle = minIdle;
        }
    }

    public static void main(String[] args) {
        ResourcePoolConfig resourcePoolConfig = new ResourcePoolConfig("dbconnectionpool",16,null,null);
        //面对这种模式，采用set方式
    }
}
