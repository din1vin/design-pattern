package c05.template;

public abstract class Template {
    public final void templatedMethod(){
        method1();
        method2();
    }

    protected abstract void method2();

    protected abstract void method1();
}
