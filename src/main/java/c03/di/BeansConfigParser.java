package c03.di;

import java.io.InputStream;
import java.util.List;

public interface BeansConfigParser {
    List<BeanDefinition> parse(InputStream in);
}
