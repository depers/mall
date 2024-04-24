package cn.bravedawn.jvm.tool;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/19 20:25
 */
public class JhsdbTestCase {

    /**
     * VM参数：-Xmn10M -XX:+UseSerialGC -XX:-UseCompressedOops
     */

    static class Test {
        static ObjectHandler staticObj = new ObjectHandler();
        ObjectHandler instanceObj = new ObjectHandler();

        void foo() {
            ObjectHandler localObj = new ObjectHandler();
            System.out.println("done");
        }
    }


    private static class ObjectHandler{}


    public static void main(String[] args) {
        Test test = new JhsdbTestCase.Test();
        test.foo();
    }
}
