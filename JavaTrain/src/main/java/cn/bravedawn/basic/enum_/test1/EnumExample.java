package cn.bravedawn.basic.enum_.test1;

public class EnumExample {

    // Java枚举要解决的问题是：定义的普通常量类，编译器无法检查每个值的合理性

    static void test1(int weekday) {
        // 我们定义的Weekday的常量值范围是0-6，并不包含7，编译器无法检查不在枚举中的int值
        if (weekday == 6 || weekday == 7) {
            // todo
        }
    }


    static void test2(int month) {
        // 我们订定义的Weekday常量仍然可以与其它变量比较，但其用途并非是枚举星期值
        if (month == Weekday.MON) {
            // todo
        }
    }
}
