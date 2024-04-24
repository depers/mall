package cn.bravedawn.obj.inherit.nestedclass.staticclass;

public class Outer {

    private static String NAME = "OUTER";

    private String name;

    Outer(String name) {
        this.name = name;
    }

    static class StaticNested {
        void hello() {
            System.out.println("hello, " + Outer.NAME);
        }
    }
}
