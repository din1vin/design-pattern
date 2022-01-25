package c03.factory.simple;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactory {

    //原型模式
    public static RuleConfigParser createRuleConfigParser(String extension) {
        if ("xml".equals(extension)) {
            return new XmlConfigParser();
        } else if ("yml".equals(extension)) {
            return new YmlConfigParser();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    //单例模式
    private static Map<String, RuleConfigParser> map;

    static {
        map = new HashMap<>();
        map.put("xml", new XmlConfigParser());
        map.put("yml", new YmlConfigParser());
    }

    public static RuleConfigParser getSingletonParser(String extension) {
        return map.getOrDefault(extension, null);
    }
}
