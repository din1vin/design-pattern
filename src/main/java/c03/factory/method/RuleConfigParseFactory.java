package c03.factory.method;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParseFactory {
    private static final Map<String,IRuleConfigParser> cachedParsers =  new HashMap<>();

    static {
        cachedParsers.put("json",new JsonRuleConfigParser());
        cachedParsers.put("xml",new XmlConfigParser());
    }
}
