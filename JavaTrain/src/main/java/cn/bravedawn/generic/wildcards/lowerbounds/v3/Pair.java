package cn.bravedawn.generic.wildcards.lowerbounds.v3;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/8/3 22:26
 */
public class Pair<T>{

    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }

}
