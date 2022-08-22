package cn.bravedawn.generic.wildcards.lowerbounds.v1;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 21:40
 */
public class Plate<T>{

    T item;

    public Plate(T t) {
        this.item = t;
    }

    public void set(T t) {
        this.item = t;
    }

    public T get() {
        return item;
    }

}
