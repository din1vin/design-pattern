package c03.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator01 {
    private final AtomicLong id = new AtomicLong(0);
    private static final IdGenerator01 instance = new IdGenerator01();

    private IdGenerator01() {
    }

    public IdGenerator01 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
