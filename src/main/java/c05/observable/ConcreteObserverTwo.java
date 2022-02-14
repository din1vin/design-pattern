package c05.observable;

public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("observer two got it");
    }
}
