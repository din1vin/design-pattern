package c04.adaptor.m3replace;

public class OurDemo {
    private OutInterface outInterface;

    public OurDemo(OutInterface outInterface) {
        this.outInterface = outInterface;
    }

    public static void main(String[] args) {
        OurDemo ourDemo = new OurDemo(new OutClass());
    }
}

