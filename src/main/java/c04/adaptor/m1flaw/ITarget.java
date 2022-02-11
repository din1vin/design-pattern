package c04.adaptor.m1flaw;

import java.util.Map;

public interface ITarget {
    void unStaticFunction();
    void goodNamedFunction();
    void paramPackingFunction(Map<String,Object> args);
    void highPerformanceFunction();
}
