package cn.bravedawn.generic.wildcards.upperbounds.v2;

public class Main {

    /**
     * <? extends T>通配符的重要限制：方法参数签名setFirst(? extends T)无法传递任何T的子类给setFirst(? extends T)，本例中T为Number
     * 换句话说：方法内部无法调用传入T引用的方法（null除外），例如：obj.setFirst(T n);
     * 再说通俗点：使用 extends 通配符不能 写操作
     */

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }


    // <? extends T>作为泛型方法参数声明时使用
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //p.setFirst(new Integer(first.intValue() + 100)); //java: 不兼容的类型: java.lang.Integer无法转换为capture#1, 共 ? extends java.lang.Number
        //p.setLast(new Integer(last.intValue() + 100));
        return p.getFirst().intValue() + p.getLast().intValue();
    }
}
