package com.tomcat.beta.设计模式.建造者模式;

import org.apache.commons.lang.StringUtils;

/**
 * 构建者
 */
public class ResourcePoolConfigV1 {

    private String name;

    private int maxTotal;

    private int maxIdle;

    private int minIdle;

    private ResourcePoolConfigV1(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    private static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;

        private int maxTotal = DEFAULT_MAX_TOTAL;

        private int maxIdle = DEFAULT_MAX_IDLE;

        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfigV1 build() {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }

            if (minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }

            if (minIdle > maxTotal || minIdle > maxIdle) {
               throw new IllegalArgumentException("...");
            }

            return new ResourcePoolConfigV1(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

    public static void main(String[] args) {
        ResourcePoolConfigV1 resourcePoolConfigV1 = new ResourcePoolConfigV1
                .Builder()
                .setMaxIdle(10)
                .setName("test")
                .setMaxTotal(16)
                .setMinIdle(12)
                .build();
    }
}
