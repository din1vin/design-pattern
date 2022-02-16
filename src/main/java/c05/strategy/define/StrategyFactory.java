package c05.strategy.define;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private static final Map<String,Strategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("A",new ConcreteStrategyA());
        strategyMap.put("B",new ConcreteStrategyB());
    }

    public Strategy getStrategy(String type){
        if(type==null||type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategyMap.get(type);
    }
}
