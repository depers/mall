package cn.bravedawn.obj.object;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 15:04
 */
public class StaticInnerClassExample {

    /**
     * 静态内部类的引用传递测试
     */

    public static void main(String[] args) {
        StaticInnerClassExample t = new StaticInnerClassExample();
        t.start();
    }


    public void start() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        change(v, i);
        System.out.println(v.i); // 20

        /**
         * 这里为啥会打印出20呢？不是15
         * 按照我的分析，在change方法中，新的Value对象的引用在change方法结束后就被销毁了，所以回到start方法，v的引用指向回到了原来的实例上面
         */
    }


    public void change(Value v, int i) {
        i = 0;
        v.i = 20;

        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i); // 15 0
    }

    static class Value{
        public int i = 15;
    }
}
