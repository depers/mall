package cn.bravedawn.reflection;

public class ReflectionExample {


    /**
     * Class类的基本api方法
     */

    public static void main(String[] args) {
        printClassInfo("".getClass());
        System.out.println("-----------------------");
        printClassInfo(Runnable.class);
        System.out.println("-----------------------");
        printClassInfo(java.time.Month.class);
        System.out.println("-----------------------");
        printClassInfo(String[].class);
        System.out.println("-----------------------");
        printClassInfo(int.class);
    }


    static void printClassInfo(Class cls) {
        // 获取class全类名
        System.out.println("Class name: " + cls.getName());
        // 获取class的类名称
        System.out.println("Simple name: " + cls.getSimpleName());

        // 获取类所在的包名
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }

        // 判断类是否是一个接口
        System.out.println("is interface: " + cls.isInterface());

        // 判断类是否是一个枚举类
        System.out.println("is enum: " + cls.isEnum());

        // 判断类是否是一个数组
        System.out.println("is array: " + cls.isArray());

        // 判断类是否是原始类型
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
