package c04.proxy;

/**
 * 请求信息记录
 */
public class RequestInfo {
    private String method;
    private long spent;

    public RequestInfo(String method, long spent) {
        this.method = method;
        this.spent = spent;
    }
}
