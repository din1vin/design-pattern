package c02;

public interface TransactionLock {
    boolean lock(String id);

    void unlock();
}
