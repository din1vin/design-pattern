package c04.proxy;

/**
 * 未使用代理模式的例子
 * 如果需要设计一个请求调用计数器
 */
public class UserController {
    private MetricsController metricsController;

    //setter 注入
    public UserController(MetricsController metricsController) {
        this.metricsController = metricsController;
    }

    public void login(String userName, String password) {
        long currentTimeMillis = System.currentTimeMillis();
        // .  省略登陆逻辑  login with userName && password .
        long endTimeMills = System.currentTimeMillis();
        long time = endTimeMills = currentTimeMillis;
        RequestInfo login = new RequestInfo("login", time);
        metricsController.recordRequest(login);
    }


    public void register(String userName, String password) {
        long currentTimeMillis = System.currentTimeMillis();
        // .  省略注册逻辑  register with userName && password .
        long endTimeMills = System.currentTimeMillis();
        long time = endTimeMills = currentTimeMillis;
        RequestInfo register = new RequestInfo("register", time);
        metricsController.recordRequest(register);
    }
}
