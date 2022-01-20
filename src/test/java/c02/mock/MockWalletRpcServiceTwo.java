package c02.mock;

import c02.WalletRpcService;

public class MockWalletRpcServiceTwo extends WalletRpcService {
    @Override
    public String moveMoney(String id, Long buyerId, Long sellerID, Double amount) {
        return null;
    }
}
