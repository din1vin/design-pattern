package c03.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator04 {
    private final AtomicLong id = new AtomicLong(0);
    private static volatile IdGenerator04 instance;

    private IdGenerator04() {
    }

    private static class IdGeneratorHolder {
        private static final IdGenerator04 instance = new IdGenerator04();
    }

    public static synchronized IdGenerator04 getInstance() {
        return IdGeneratorHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
