package c03.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private BeansFactory beansFactory;
    private BeansConfigParser beansConfigParser;

    public ClassPathXmlApplicationContext(String configPath) {
        this.beansFactory = new BeansFactory();
        this.beansConfigParser = new XmlBeanConfigParser();
        loadBeansDefinitions(configPath);
    }

    private void loadBeansDefinitions(String configPath) {

        try (InputStream in = this.getClass().getResourceAsStream("/" + configPath)) {
            if (in == null) {
                throw new RuntimeException("Can not find config file:" + configPath);
            }
            List<BeanDefinition> beanDefinitions = beansConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
