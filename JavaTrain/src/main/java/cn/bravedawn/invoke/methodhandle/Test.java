package cn.bravedawn.invoke.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/1/31 11:52
 */
public class Test {

    /**
     * 通过MethodHandle方法句柄实现方法的调用，又称为"现代反射"
     */


    // 获取方法句柄
    public static MethodHandle getToStringMH() {
        //获取方法类型 参数为:1.返回值类型,2方法中参数类型
        MethodType mt = MethodType.methodType(String.class, String.class);
        MethodHandle mh = null;
        try {
            //查找方法句柄
            mh = MethodHandles.lookup().findVirtual(MethodHandleClass.class, "toString", mt);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return mh;
    }


    public static void main(String[] args) throws Throwable {
        MethodHandleClass handleClass = new MethodHandleClass();
        MethodHandle mh = getToStringMH();

        // 1.根据方法句柄调用方法
        String result = (String) mh.invokeExact(handleClass, "world");  //根据方法句柄调用方法----注意返回值必须强转
        System.out.println("通过方法句柄调用方法" + result);


        // 2.方法二
        MethodHandle methodHandle2 = mh.bindTo(handleClass);
        String result2 = (String) methodHandle2.invokeWithArguments("app");
        System.out.println("第二种方式" + result2);

    }
}