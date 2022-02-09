package c03.di;

import org.jetbrains.annotations.VisibleForTesting;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class BeansFactory {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beansDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitions) {
        beanDefinitions.forEach(x -> this.beansDefinitions.putIfAbsent(x.getId(), x));
        beanDefinitions.forEach(x -> {
            if (!x.isLazyInit() && x.isSingleton()) {
                createBean(x);
            }
        });
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beansDefinitions.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchElementException("bean is not defined:" + beanId);
        }
        return createBean(beanDefinition);
    }

    @VisibleForTesting
    protected Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }
        Object bean = null;

        try {
            Class<?> beanClass = Class.forName(beanDefinition.getClassName());
            List<ConstructArg> args = beanDefinition.getConstructArgs();
            if (args.isEmpty()) {
                bean = beanClass.getDeclaredConstructor().newInstance();
            } else {
                int argsNum = args.size();
                Class[] argClass = new Class[argsNum];
                Object[] argObject = new Object[argsNum];
                for (int i = 0; i < argsNum; i++) {
                    ConstructArg arg = args.get(i);
                    if (!arg.isRef()) {
                        argClass[i] = arg.getType();
                        argObject[i] = arg.getArg();
                    } else {
                        BeanDefinition refBeanDefinition = beansDefinitions.get(arg.getArg());
                        if (refBeanDefinition == null) {
                            throw new NoSuchElementException("Bean is not defined: " + arg.getArg());
                        }
                        argClass[i] = Class.forName(refBeanDefinition.getClassName());
                        argObject[i] = createBean(refBeanDefinition);
                    }
                    bean = beanClass.getConstructor(argClass).newInstance(argObject);
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
