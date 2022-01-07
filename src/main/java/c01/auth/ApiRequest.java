package c01.auth;


public class ApiRequest {
    private String baseUrl;
    private String token;
    private long timestamp;
    private String appID;

    public ApiRequest(String baseUrl, String token, long timestamp, String appID) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.timestamp = timestamp;
        this.appID = appID;
    }

    public static ApiRequest createFromFullUrl(String url) {
        //TODO 解析URL,生成参数
        return new ApiRequest("","",0L,"my_app");
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getAppID() {
        return appID;
    }
}
