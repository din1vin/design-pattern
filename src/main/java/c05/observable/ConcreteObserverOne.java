package c05.observable;

public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("observer one got it");
    }
}
