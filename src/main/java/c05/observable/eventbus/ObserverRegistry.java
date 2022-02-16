package c05.observable.eventbus;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {
    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        observerActions.forEach((k, v) -> {
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(k);
            if (registeredEventActions == null) {
                registry.putIfAbsent(k, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(k);
            }
            registeredEventActions.addAll(v);
        });
    }

    public List<ObserverAction> getMatchedObserverActions(Object observer) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = observer.getClass();
        registry.forEach((k, v) -> {
            if (postedEventType.isAssignableFrom(k)) {
                matchedObservers.addAll(v);
            }
        });
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> observerClazz = observer.getClass();
        for (Method method : getAnnotatedMethod(observerClazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> classType = parameterTypes[0];
            if (!observerActions.containsKey(classType)) {
                observerActions.put(classType, new ArrayList<>());
            }
            observerActions.get(classType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    private List<Method> getAnnotatedMethod(Class<?> observerClazz) {
        List<Method> methods = new ArrayList<>();
        for (Method method : observerClazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        String.format("Method %s has @Subscribe but has %s parameters.", method, parameterTypes.length));
                methods.add(method);
            }
        }
        return methods;
    }
}
