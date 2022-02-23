package cn.bravedawn.generic.genericmethod;

public class GenericMethod3<T> {

    /**
     * 静态方法和泛型
     * 如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法。静态方法不能使用泛型类中已经声明过的泛型
     */


    public static <T> void show(T t) {

    }

}
