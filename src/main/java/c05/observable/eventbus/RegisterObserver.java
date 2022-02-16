package c05.observable.eventbus;

public class RegisterObserver {

    @Subscribe
    public void afterRegister(Long userId) {
        //todo do something with userId
    }
}
