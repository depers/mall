package cn.bravedawn.obj.inherit.nestedclass.localclass;

public class Outer {

    /**
     * 本地类
     */

    int num = 10;
    public void func() {

        int num = 20;
        class Inner {
            public void hello(){
                System.out.println(num);
            }
        }

        Inner inner = new Inner();
        inner.hello();
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.func();
    }

}
