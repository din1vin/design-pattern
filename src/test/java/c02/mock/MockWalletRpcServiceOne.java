package c02.mock;

import c02.WalletRpcService;

public class MockWalletRpcServiceOne extends WalletRpcService {

    @Override
    public String moveMoney(String id, Long buyerId, Long sellerID, Double amount) {
        return "1343jgd";
    }
}
