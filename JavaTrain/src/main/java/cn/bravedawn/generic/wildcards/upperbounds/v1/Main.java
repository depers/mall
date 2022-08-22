package cn.bravedawn.generic.wildcards.upperbounds.v1;

public class Main {

    /**
     * 因为Pair<Integer>不是Pair<Number>的子类，所以报错
     */

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        //int n = add(p); // Pair<java.lang.Integer>无法转换为Pair<java.lang.Number>

    }


    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}
