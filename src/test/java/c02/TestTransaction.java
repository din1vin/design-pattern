package c02;

import c02.mock.MockTransactionLock;
import c02.mock.MockWalletRpcServiceOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTransaction {

    @Test
    public void testExecute() {
        Long buyerId = 123L;
        Long sellerId = 123L;
        Long productId = 345L;
        Long orderId = 567L;
        Transaction transaction = new Transaction(null, sellerId, buyerId, productId, orderId, 2.0);
        transaction.setLock(new MockTransactionLock());
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        boolean actual = transaction.execute();
        Assertions.assertTrue(actual);
        System.out.println("Test 1 of normal passed ✅");

    }

    @Test
    public void testAmountIllegal() {
        Long buyerId = 123L;
        Long sellerId = 123L;
        Long productId = 345L;
        Long orderId = 567L;
        Transaction transaction = new Transaction(null, sellerId, buyerId, productId, orderId, -2.0);
        transaction.setLock(new MockTransactionLock());
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        Assertions.assertThrows(IllegalTransactionException.class, transaction::execute);
        System.out.println("Test 2 of illegal amount passed ✅");
    }

    @Test
    public void testExecuteWithExpired() {
        Long buyerId = 123L;
        Long sellerId = 123L;
        Long productId = 345L;
        Long orderId = 567L;
        Transaction transaction = new Transaction(null, sellerId, buyerId, productId, orderId, 2.0) {
            @Override
            protected boolean isExpired() {
                return true;
            }
        };
        transaction.setLock(new MockTransactionLock());
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        boolean result = transaction.execute();
        Assertions.assertFalse(result);
        Assertions.assertEquals(STATUS.EXPIRED, transaction.getStatus());
        System.out.println("Test 3 of expired time passed ✅");
    }
}
