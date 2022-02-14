package c05.observable;

import java.time.LocalDateTime;

public class Message {
    private final String message;
    private final String tms;

    public Message(String message) {
        this.message = message;
        this.tms = LocalDateTime.now().toString();
    }

    public String getMessage() {
        return message;
    }

    public String getTms() {
        return tms;
    }
}
