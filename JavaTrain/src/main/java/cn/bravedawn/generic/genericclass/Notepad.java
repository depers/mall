package cn.bravedawn.generic.genericclass;

public class Notepad <K, V>{

    /**
     * 定义一个多元泛型类，这里指定了两个泛型类型
     */

    private K key; // 此变量的类型由外部指定
    private V value; // 此变量的类型由外部指定

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
