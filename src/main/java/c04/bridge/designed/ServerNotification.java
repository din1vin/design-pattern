package c04.bridge.designed;

public class ServerNotification extends Notification {
    public ServerNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
