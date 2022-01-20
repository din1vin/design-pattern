package c02;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class Transaction {
    public static final long day14 = 14 * 24 * 3600;

    private final String id;
    private final Long buyerId;
    private final Long sellerId;
    private final Long productId;
    private final Long orderId;
    private final Long createTimestamp;
    private final Double amount;
    private STATUS status;
    private String walletTransactionId; //分布式锁的交易ID
    private WalletRpcService walletRpcService; //依赖注入RpcService,方便测试的时候使用mockService
    private TransactionLock lock;


    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }

    public void setLock(TransactionLock lock) {
        this.lock = lock;
    }


    public String getId() {
        return id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public STATUS getStatus() {
        return status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getWalletTransactionId() {
        return walletTransactionId;
    }


    public Transaction(String preAssignId, Long sellerId, Long buyerId, Long productId, Long orderId, Double amount) {
        if (StringUtils.isNotEmpty(preAssignId)) {
            this.id = preAssignId;
        } else {
            this.id = UUID.randomUUID().toString();
        }
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTED;
        this.productId = productId;
        this.amount = amount;
        this.createTimestamp = System.currentTimeMillis();
    }

    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - createTimestamp >= day14;
    }


    public boolean execute() throws IllegalTransactionException {
        if (buyerId == null || sellerId == null || amount < 0.00) {
            throw new IllegalTransactionException("异常的交易");
        }

        if (status == STATUS.EXECUTED) return true; // 避免重复交易
        boolean isLocked = false;
        try {
            isLocked = lock.lock(id);
            if (!isLocked) {
                return false; //锁定未成功,返回false,job兜底执行
            }
            if (status == STATUS.EXECUTED) return true;
            long executionInvokedTimestamp = System.currentTimeMillis();
            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }
            String walletId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletId != null) {
                this.walletTransactionId = walletId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                lock.unlock();
            }
        }


    }
}
