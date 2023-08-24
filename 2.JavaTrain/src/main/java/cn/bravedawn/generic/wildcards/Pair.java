package cn.bravedawn.generic.wildcards;

public class Pair<T> { // public class Pair<T extends java.lang.Object> extends java.lang.Object

    /**
     * Java的类型擦除，可以使用 javap -v xx.class去查看
     */

    private T first;  // private Object first;
    private T last;  // private Object last;

    public Pair(T first, T last) { // public Pair(Object first, Object last)
        this.first = first;
        this.last = last;
    }

    public T getFirst() { // public Object getFirst()
        return first;
    }

    public T getLast() { // public Object getLast()
        return last;
    }
}
