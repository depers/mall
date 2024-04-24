package cn.bravedawn.orm;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/11/6 21:15
 */
public class ReflectionExample2 {

    /**
     * Reflection.getCallerClass()用来返回调用者的Class对象，进而通过class对象可以获取调用者的类加载器
     */


    public static void main(String[] args) {
        ReflectionExample reflectionExample = new ReflectionExample();
        reflectionExample.call();
    }
}
