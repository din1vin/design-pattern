package c03.factory.abs;

public class YmlConfigParser implements IConfigParserFactory{

    @Override
    public IRuleConfigParser createConfigParser() {
        return new YmlRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return new YmlSystemParser();
    }
}
