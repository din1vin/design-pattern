package c04.proxy.m2extends;


import c04.proxy.MetricsController;
import c04.proxy.RequestInfo;
import c04.proxy.m1impl.UserController;

public class UserControllerProxy extends UserController {
    private MetricsController metricsController;

    public UserControllerProxy(MetricsController metricsController) {
        this.metricsController = metricsController;
    }

    @Override
    public void login(String userName, String password) {
        long start = System.currentTimeMillis();
        super.login(userName, password);
        long end = System.currentTimeMillis();
        RequestInfo login = new RequestInfo("login", end - start);
        metricsController.recordRequest(login);
    }

    @Override
    public void register(String userName,String password){
        long start = System.currentTimeMillis();
        super.register(userName, password);
        long end = System.currentTimeMillis();
        RequestInfo register = new RequestInfo("register", end - start);
        metricsController.recordRequest(register);
    }
}
