package c04.bridge.normal;

public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > apiStatInfo.getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SERVER,"max error count");
        }
    }
}
