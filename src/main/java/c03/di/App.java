package c03.di;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) context.getBean("rateLimiter");
        rateLimiter.test();
    }
}
