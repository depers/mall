package cn.bravedawn.generic.genericmethod;

public class GenericMethod2 <T>{


    /**
     * 泛型类中的泛型方法
     */


    /**
     * 1.可以声明多个泛型
     * 2.这个泛型方法的 T和泛型方法的T没有任何关系，是一种全新的类型
     */
    public <K, T> T ShowKeyName(K key) {
        // ...
        return null;
    }
}
