package c05.observable;

public interface Subject {
    void registerObserver(Observer objectServer);
    void removeObserver(Observer observer);
    void notifyObserver(Message message);
}
