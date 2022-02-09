package c03.builder;

import org.apache.commons.lang3.StringUtils;

public class ResourcePoolConfig {


    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    private static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        String name;
        int maxTotal = DEFAULT_MAX_TOTAL;
        int maxIdle = DEFAULT_MAX_IDLE;
        int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("name can not be null");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle is bigger than maxTotal!");
            }

            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("illegal min Idle");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (name.contains("#")) {
                throw new IllegalArgumentException("name  should not contains '#'");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("max total should greater than zero");
            }
            this.maxTotal = maxTotal;
            return this;
        }
    }
}
