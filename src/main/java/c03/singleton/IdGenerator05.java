package c03.singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGenerator05 {
    INSTANCE;
    private final AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
