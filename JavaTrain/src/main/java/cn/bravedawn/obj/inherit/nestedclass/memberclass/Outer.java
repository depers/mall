package cn.bravedawn.obj.inherit.nestedclass.memberclass;

public class Outer {

    private String name;

    Outer(String name) {
        this.name = name;
    }

    class Inner {

        static int a = 1;

        void hello() {
            System.out.println("Hello, " + Outer.this.name);
        }
    }
}
