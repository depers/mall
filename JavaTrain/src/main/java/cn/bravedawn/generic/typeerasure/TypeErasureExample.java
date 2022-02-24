package cn.bravedawn.generic.typeerasure;

public class TypeErasureExample {


    /**
     * Java局限一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型：
     */

    public static void main(String[] args) {
        //Pair<int> p = new Pair<>(1, 2); // compile error!
    }
}
