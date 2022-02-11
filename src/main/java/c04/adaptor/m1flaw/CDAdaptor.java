package c04.adaptor.m1flaw;

import java.util.Map;

public class CDAdaptor extends CD implements ITarget {
    @Override
    public void unStaticFunction() {
        staticFunction();
    }

    @Override
    public void goodNamedFunction() {
        super.uglyNamingFunction();
    }

    @Override
    public void paramPackingFunction(Map<String, Object> args) {
        super.tooManyArgFunction(args.values().toArray());
    }

    @Override
    public void highPerformanceFunction() {
        super.lowPerformanceFunction();
        //TODO solve performance problem
    }
}
