package cn.bravedawn.basic.enum_.test2;

public class Test {


    static void test1() {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }

    /**
     * 编译器会自动检查类型错误
     */
    static void test2() {
        int day = 1;
        //if (day == Weekday.SAT) { // compile error

        // }
    }

    /**
     * 不同类型的枚举不能互相比较和复制，因为类型不符
     */
    static void test3() {
        Weekday x = Weekday.SAT;
        // Weekday y = Color.BLUE; // compile error
    }
}
