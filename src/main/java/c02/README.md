# 编写单元测试实战

 [Transaction](design-pattern/src/main/java/c02/Transaction.java) 类是经过抽象简化的电商系统的交易类,
 用来记录每笔订单的交易情况,Transaction类中的execute()函数负责执行转账操作,将钱从买家的钱包转移到卖家钱包中.
 真正的操作是通过调用WalletRpcService RPC服务来完成的.