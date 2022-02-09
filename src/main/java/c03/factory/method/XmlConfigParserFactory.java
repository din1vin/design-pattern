package c03.factory.method;

public class XmlConfigParserFactory implements IRuleConfigSourceFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlConfigParser();
    }
}
