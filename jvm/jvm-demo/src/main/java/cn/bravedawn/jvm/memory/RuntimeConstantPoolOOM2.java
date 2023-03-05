package cn.bravedawn.jvm.memory;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/3/5 11:02
 */
public class RuntimeConstantPoolOOM2 {

    /**
     * String.intern方法在jdk6和jdk7下的不同表现
     */


    public static void main(String[] args) {
        // str1是在堆上创建的一个对象
        String str1 = new StringBuilder("计算机").append("软件").toString();
        // str.intern从常量池中获取字符串对象时，若该对象已在堆上存在，则直接返回该对象的引用，所以是同一个对象
        System.out.println(str1.intern() == str1); // true

        // str2是堆上的创建的一个对象
        String str2 = new StringBuilder("ja").append("va").toString();
        // 按照书上的说法在str2创建之前，常量池中已经存在了对java字符串的对象引用，所以这是两个不同的对象
        System.out.println(str2.intern() == str2); // false

        // 这里我现在常量池放了一个fengxiao的字符串对象
        String str3 = "fengxiao";
        // 然后在堆上去创建的了一个对象
        String str4 = new String("fengxiao");
        // 常量池和堆上的对象是两个不同的对象
        System.out.println(str3 == str4); // false

    }
}
