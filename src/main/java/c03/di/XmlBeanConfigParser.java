package c03.di;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlBeanConfigParser implements BeansConfigParser {
    @Override
    public List<BeanDefinition> parse(InputStream in) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        //TODO parse stream
        return beanDefinitions;
    }
}
