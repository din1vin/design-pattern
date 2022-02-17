package c05.iter;

public interface Iterator <E>{
    boolean hasNext();
    void next();
    E currentItem();
}
