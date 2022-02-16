package c04.proxy.m3dynamic;

import c04.proxy.MetricsController;
import c04.proxy.RequestInfo;
import c04.proxy.m1impl.IUser;
import c04.proxy.m1impl.UserController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MetricsProxy {
    private MetricsController metricsController;

    public MetricsProxy(MetricsController metricsController) {
        this.metricsController = metricsController;
    }

    public Object createProxy(Object proxyObject) {
        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxyObject);
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxyObject;

        public DynamicProxyHandler(Object proxyObject) {
            this.proxyObject = proxyObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            long start = System.currentTimeMillis();
            Object result = method.invoke(proxyObject, args);
            long end = System.currentTimeMillis();
            String apiName = proxyObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, end - start);
            metricsController.recordRequest(requestInfo);
            return result;
        }
    }

    public static void main(String[] args) {
        MetricsController metricsController = new MetricsController();
        MetricsProxy proxy = new MetricsProxy(metricsController);
        IUser iUser = (IUser) proxy.createProxy(new UserController());
        iUser.login("111", "222");
        iUser.register("111", "222");
    }

}
