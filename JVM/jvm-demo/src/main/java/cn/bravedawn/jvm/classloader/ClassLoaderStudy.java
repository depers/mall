package cn.bravedawn.jvm.classloader;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/8 16:17
 */
public class ClassLoaderStudy {

    /**
     * 获取对应类的类加载器
     */


    public static void main(String[] args) throws Exception{
        String str = "hello class Loader";
        System.out.println("str class loader = " + str.getClass().getClassLoader()); // null

        Class driver = Class.forName("java.sql.Driver");
        System.out.println("driver class loader = " + driver.getClassLoader()); // PlatformClassLoader
        System.out.println("driver parent class loader = " + driver.getClassLoader().getParent()); // null

        ClassLoaderStudy t = new ClassLoaderStudy();
        System.out.println("t class loader = " + t.getClass().getClassLoader()); // AppClassLoader
        System.out.println("t parent class loader = " + t.getClass().getClassLoader().getParent()); // PlatformClassLoader
        System.out.println("t parent parent class loader = " + t.getClass().getClassLoader().getParent().getParent()); // null

        Class jshell = Class.forName("jdk.jshell.JShell");
        System.out.println("jshell class loader = " + jshell.getClassLoader()); // AppClassLoader
    }
}
