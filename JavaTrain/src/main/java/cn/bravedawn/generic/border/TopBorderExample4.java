package cn.bravedawn.generic.border;

public class TopBorderExample4 {


    /**
     * 承接TopBorderExample3，将add方法的参数修改为Pair<? extends Number> p，
     * 这样泛型定义称之为上界通配符（Upper Bounds Wildcards），即把泛型类型T的上界限定在Number，所有实参都必须是Number的子类
     */

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }



    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}
