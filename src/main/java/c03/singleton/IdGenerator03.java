package c03.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator03 {
    private final AtomicLong id = new AtomicLong(0);
    private static volatile IdGenerator03 instance;

    private IdGenerator03() {
    }

    public static synchronized IdGenerator03 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator03.class) {
                if (instance == null) {
                    instance = new IdGenerator03();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
