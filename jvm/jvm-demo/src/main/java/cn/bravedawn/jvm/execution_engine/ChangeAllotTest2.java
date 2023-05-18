package cn.bravedawn.jvm.execution_engine;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/14 18:21
 */
public class ChangeAllotTest2 {

    /**
     * 修改方法的分派规则（解开访问保护）
     */

    class GrandFather {
        void thinking() {
            System.out.println("I am grandfather");
        }
    }

    class Father extends GrandFather {

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
                Field field = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                field.setAccessible(true);
                MethodHandle methodHandle = ((MethodHandles.Lookup) field.get(null))
                        .findSpecial(GrandFather.class, "thinking", type, GrandFather.class);
                methodHandle.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ((new ChangeAllotTest2()).new Son()).thinking();
    }
}
