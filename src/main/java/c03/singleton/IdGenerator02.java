package c03.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator02 {
    private final AtomicLong id = new AtomicLong(0);
    private static IdGenerator02 instance;

    private IdGenerator02() {
    }

    public static synchronized IdGenerator02 getInstance() {
        if (instance == null) {
            instance = new IdGenerator02();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
