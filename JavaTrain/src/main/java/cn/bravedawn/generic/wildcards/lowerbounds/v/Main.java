package cn.bravedawn.generic.wildcards.lowerbounds.v;

import cn.bravedawn.generic.wildcards.Pair;

public class Main {

    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 100);
        System.out.println(p1.getFirst() + ", " + p1.getLast()); // 100, 4.56
        System.out.println(p2.getFirst() + ", " + p2.getLast()); // 100, 456
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setFirst(n);
    }

}
