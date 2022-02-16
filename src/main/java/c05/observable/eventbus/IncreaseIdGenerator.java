package c05.observable.eventbus;

import java.util.concurrent.atomic.AtomicLong;

public class IncreaseIdGenerator implements IdGenerator<Long> {
    private final AtomicLong id;

    public IncreaseIdGenerator() {
        this.id = new AtomicLong();
    }


    @Override
    public Long next() {
        return id.incrementAndGet();
    }
}
