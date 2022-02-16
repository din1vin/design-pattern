package c05.observable.eventbus;

public final class Preconditions {
    public static Object checkNotNull(Object object) {
        if (object == null) throw new RuntimeException("target object can't be null");
        return object;
    }

    public static void checkArgument(boolean assertCheck, String msg) {
        if (!assertCheck) {
            throw new RuntimeException(msg);
        }
    }
}
