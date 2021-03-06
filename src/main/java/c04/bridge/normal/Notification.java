package c04.bridge.normal;

import java.util.List;

public class Notification {
    private List<String> emailAddress;
    private List<String> telephones;
    private List<String> wechatIds;

    public Notification() {
    }

    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SERVER)) {
            // ...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //... 发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //... 发邮件
        }else  if(level.equals(NotificationEmergencyLevel.TRIVIAL)){
            //... 发邮件
        }
    }

}
