package cn.bravedawn.jvm.triggerclassinit;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 21:41
 */
public class Test {

    // 6.JVM启动的时候运行的主类，会自动进行初始化
    // static {
    //     System.out.println("now Test class init");
    // }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        // 1.创建类实例
        // MyChild myChild = new MyChild();

        // 2.访问某个类或接口的静态变量
        // System.out.println("MyClass static variable a=" + MyChild.a);

        // 3.调用类的静态方法
        // MyChild.t1();

        // 4.反射某个类
        // Class cls = Class.forName("cn.bravedawn.jvm.triggerclassinit.MyChild");

        // 5.初始化某个类而父类还没有初始化时，会联动初始化其父类
        // MyChild myChild = new MyChild();

        // 7.定义了default方法的接口，当接口的实现类初始化时就会初始化接口
        // 这里我们将MyChild的实例转为了接口实例，由于MyChild类并没有对MyInterface的t2()方法进行覆盖，所以他调用的是MyInterface的t2()方法；
        // 也就是说在对类进行初始化时会同步初始化它的接口
        MyInterface myInterface = (MyInterface) (Class.forName("cn.bravedawn.jvm.triggerclassinit.MyChild").newInstance());
        myInterface.t2();
    }
}
