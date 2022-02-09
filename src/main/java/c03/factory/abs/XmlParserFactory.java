package c03.factory.abs;



public class XmlParserFactory implements IConfigParserFactory{
    @Override
    public IRuleConfigParser createConfigParser() {
        return new XmlConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return new XmlSystemParser();
    }
}
