package cn.bravedawn.jvm.classloader;

import java.sql.DriverManager;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/10 22:36
 */
public class DriverManagerTest {

    /**
     * 父级类加载器通过 线程上下文加载器 获取子级类加载器去完成类的加载
     * 也就是说DriverManager的加载器PlatformClassLoader要通过线程上下文加载器获取到Driver的AppClassLoader去加载Driver
     */

    public static void main(String[] args) throws ClassNotFoundException {
        Class driverClass = Class.forName("java.sql.DriverManager");
        System.out.println("DriverManager class loader = " + driverClass.getClassLoader()); // PlatformClassLoader


        Class mySQLDriverClass = Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Mysql Driver class loader = " + mySQLDriverClass.getClassLoader()); //AppClassLoader
    }
}
