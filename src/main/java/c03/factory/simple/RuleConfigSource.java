package c03.factory.simple;

public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String extension = getFileExtension(ruleConfigFilePath);
        RuleConfigParser parser = RuleConfigParserFactory.createRuleConfigParser(extension);
        return parser.parse();
    }

    private String getFileExtension(String ruleConfigFilePath) {
        if(ruleConfigFilePath.contains(".")){
            return ruleConfigFilePath.split("\\.")[1];
        }else {
            return "xml";
        }
    }
}
