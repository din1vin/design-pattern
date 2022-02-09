package c03.factory.method;

public class JsonRuleConfigParserFactory implements IRuleConfigSourceFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
