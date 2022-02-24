package cn.bravedawn.generic.typeerasure;

public class TypeErasureExample4<T> {

    /**
     * 该方法是不能通过编译的，该方法与Object的equals方法经过类型擦除后都会变成equals(Object)方法，从而造成的冲突
     */
    //public boolean equals(T t) {
    //    return this == t;
    //}


    /**
     * 换个方法名其实就合适了
     */
    public boolean same(T t) {
        return this == t;
    }
}
