package c03.di;

public class RateLimiter {
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test(){
        System.out.println("Hello Dependency Injection");
    }
}

