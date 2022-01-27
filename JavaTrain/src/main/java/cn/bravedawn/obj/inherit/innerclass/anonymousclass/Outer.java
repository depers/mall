package cn.bravedawn.obj.inherit.innerclass.anonymousclass;

public class Outer {

    private String name;

    Outer(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello, " + Outer.this.name);
            }
        };

        new Thread(r).start();
    }
}
