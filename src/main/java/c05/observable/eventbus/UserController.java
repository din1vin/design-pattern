package c05.observable.eventbus;

import c05.observable.Observer;

import java.util.List;
import java.util.concurrent.Executors;

public class UserController {
    private UserService userService;
    private EventBus eventBus;
    private static final int DEFAULT_EVENT_BUS_THREAD_POOL_SIZE = 10;

    public UserController(UserService userService) {
        this.userService = userService;
        // this.eventBus = new EventBus(); // sync way
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENT_BUS_THREAD_POOL_SIZE));
    }

    public void setObserver(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {
        // ... omit param check
        Long userId = userService.register(telephone, password);
        eventBus.post(userId);
        return userId;
    }

}
