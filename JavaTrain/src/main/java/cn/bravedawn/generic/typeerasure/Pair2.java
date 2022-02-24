package cn.bravedawn.generic.typeerasure;

public class Pair2<T> {

    /**
     * Java局限四：不能实例化T类型
     */

    private T first;
    private T last;

    public Pair2() {
        //this.first = new T(); // compiler error
        //this.last = new T();
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}
