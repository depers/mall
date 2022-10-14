package cn.bravedawn.basic.keyword.static_.innerclass;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/18 17:07
 */
public class OuterClass {

    /**
     * 非静态内部类依赖于外部类的实例，必须先创建外部类实例才能去创建非静态内部类实例
     */

    class InnerClass{

    }

    static class StaticInnerClass {

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
