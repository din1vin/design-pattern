package c03.factory.abs;

public interface IConfigParserFactory {
    IRuleConfigParser createConfigParser();
    ISystemConfigParser createSystemConfigParser();
}
