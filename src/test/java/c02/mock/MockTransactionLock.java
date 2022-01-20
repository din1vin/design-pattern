package c02.mock;

import c02.TransactionLock;

public class MockTransactionLock implements TransactionLock {
    @Override
    public boolean lock(String id) {
        return true;
    }

    @Override
    public void unlock() {

    }
}
