package c04.bridge.normal;

public class ApiStatInfo {
    private String api;
    private int errorCount;
    private final int maxErrorCount;

    public ApiStatInfo(String api, int maxErrorCount) {
        this.api = api;
        this.maxErrorCount = maxErrorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public String getApi() {
        return api;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getMaxErrorCount() {
        return maxErrorCount;
    }
}
