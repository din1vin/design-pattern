package c05.observable.eventbus;

public class UserService {
    public Long register(String telephone, String password) {
        // todo save {telephone} and {password} to DB
       return new IncreaseIdGenerator().next();
    }
}
