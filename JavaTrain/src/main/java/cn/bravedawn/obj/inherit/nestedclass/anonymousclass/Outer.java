package cn.bravedawn.obj.inherit.nestedclass.anonymousclass;

public class Outer {

    /**
     * 匿名内部类的实现方法二：通过实现一个接口从而定义一个匿名类
     */

    private String name;

    Outer(String name) {
        this.name = name;
    }

    void asyncHello() {

        int count = 1;
        Runnable r = new Runnable() {

            static int a = 0;
            static final int b = 1;

            @Override
            public void run() {
                System.out.println("hello, " + Outer.this.name);
                System.out.println("count = " + count);
            }
        };

        System.out.println("r是否为一个匿名类：" + r.getClass().isAnonymousClass());
        new Thread(r).start();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("hello");
        outer.asyncHello();
    }
}
