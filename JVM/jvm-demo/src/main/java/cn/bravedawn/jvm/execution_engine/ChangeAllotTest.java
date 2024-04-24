package cn.bravedawn.jvm.execution_engine;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/14 18:14
 */
public class ChangeAllotTest {


    /**
     * 修改方法的分派规则（在JDK7 Update 9之后，受到访问控制的限制）
     */


    class GrandFather {
        void thinking() {
            System.out.println("I am grandfather");
        }
    }

    class Father extends GrandFather{

        @Override
        void thinking() {
            System.out.println("I am father");
        }
    }


    class Son extends Father {

        @Override
        void thinking() {
            try {
                MethodType type = MethodType.methodType(void.class);
                MethodHandle handle = MethodHandles.lookup()
                        .findSpecial(GrandFather.class, "thinking", type, getClass());
                handle.invoke(this); // I am father
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ((new ChangeAllotTest()).new Son()).thinking();
    }
}
