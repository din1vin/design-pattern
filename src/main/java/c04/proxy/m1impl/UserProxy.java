package c04.proxy.m1impl;

import c04.proxy.MetricsController;
import c04.proxy.RequestInfo;

public class UserProxy implements IUser {
    private UserController userController;
    private MetricsController metricsController;

    // 构造器注入
    public UserProxy(UserController userController, MetricsController metricsController) {
        this.userController = userController;
        this.metricsController = metricsController;
    }

    @Override
    public void login(String userName, String password) {
        long start = System.currentTimeMillis();
        userController.login(userName, password);
        long end = System.currentTimeMillis();
        RequestInfo login = new RequestInfo("login", end - start);
        metricsController.recordRequest(login);
    }

    @Override
    public void register(String userName, String password) {
        long start = System.currentTimeMillis();
        userController.register(userName, password);
        long end = System.currentTimeMillis();
        RequestInfo register = new RequestInfo("register", end - start);
        metricsController.recordRequest(register);
    }
}
