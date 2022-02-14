package c05.observable;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer objectServer) {
        observers.add(objectServer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {
        observers.forEach(x-> x.update(message));
    }
}
