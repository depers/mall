package cn.bravedawn.generic.typeerasure;

public class Pair2<T> {

    /**
     * Java局限四：不能实例化T类型
     * 泛型中不能new T()的原因有两个：
     *      一是因为擦除，不能确定类型
     *      二是无法确定T中是否包含无参构造函数
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
