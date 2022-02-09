package c03.di;


import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructArg> constructArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public BeanDefinition(String id, String className, List<ConstructArg> constructArgs, Scope scope, boolean lazyInit) {
        this.id = id;
        this.className = className;
        this.constructArgs = constructArgs;
        this.scope = scope;
        this.lazyInit = lazyInit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructArg> getConstructArgs() {
        return constructArgs;
    }

    public void setConstructArgs(List<ConstructArg> constructArgs) {
        this.constructArgs = constructArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
