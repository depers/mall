package cn.bravedawn.jvm.triggerclassinit;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/30 21:00
 */
public class InitOrderClass {

    /**
     * 观察类的初始化化顺序
     */

    //执行顺序第一步
    private static InitOrderClass cls = new InitOrderClass();

    // 执行顺序第三步：a=0
    private static int a = 0;
    // 执行顺序第四步：b = 1
    private static int b;

    // 执行顺序第二步：此时a=1,b=1
    private InitOrderClass() {
        a++;
        b++;
        System.out.println("此时a=" + a + ", b=" + b);
    }

    public static InitOrderClass getInstance() {
        return cls;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }


    public static void main(String[] args) {
        InitOrderClass instance = InitOrderClass.getInstance();
        System.out.println(instance.getA()); // 0
        System.out.println(instance.getB()); // 1
    }
}
