package cn.bravedawn.generic.wildcards.lowerbounds.v;

import cn.bravedawn.generic.wildcards.Pair;

public class Test {


    public static void main(String[] args) {
        Pair<? super Integer> p = new Pair<>(123, 1234);
        Integer a = 100;
        p.setFirst(100);
        Object last = p.getLast();


    }
}
