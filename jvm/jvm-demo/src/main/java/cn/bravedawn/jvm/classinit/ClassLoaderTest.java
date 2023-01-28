package cn.bravedawn.jvm.classinit;

import cn.bravedawn.jvm.classloader.MyClassLoader;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 21:09
 */
public class ClassLoaderTest {

    /**
     * 运行main方法之后，你就会发现没有任何打印，也就是说没有做类的初始化
     */

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = new MyClassLoader("InitClassLoader");
        Class<?> cls = classLoader.loadClass("cn.bravedawn.jvm.classinit.MyChild");
    }
}
