package c04.adaptor.m3replace;

public class OurAdaptor implements OutInterface {
    private OutClass outClass;

    public OurAdaptor(OutClass outClass) {
        this.outClass = outClass;
    }

    @Override
    public void outFunction() {
        outClass.outFunction();
    }

    public static void main(String[] args) {
        // 借助Adaptor可以在修改的时候涉及Out的都无需改动
        new OurDemo(new OurAdaptor(new OutClass()));
    }
}
