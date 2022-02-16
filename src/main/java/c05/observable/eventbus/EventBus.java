package c05.observable.eventbus;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EventBus {

    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(Executors.newSingleThreadExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object observer) {
        registry.register(observer);
    }

    /**
     * send message to observers
     *
     * @param event the message
     */
    public void post(Object event) {
        List<ObserverAction> matchedObserverActions = registry.getMatchedObserverActions(event);
        for (ObserverAction matchedObserverAction : matchedObserverActions) {
            executor.execute(() -> matchedObserverAction.execute(event));
        }
    }

}
