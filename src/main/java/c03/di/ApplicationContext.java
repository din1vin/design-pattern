package c03.di;

//执行入口
public interface ApplicationContext {
    Object getBean(String beanId);
}
