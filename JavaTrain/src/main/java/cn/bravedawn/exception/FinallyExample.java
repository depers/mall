package cn.bravedawn.exception;

public class FinallyExample {

    /**
     * 若try里面有一个return语句，则finally里面的code会不会执行，是在return前还是后？
     * 1. finally里面的code会执行
     * 2. 在return前执行
     */

    public static void main(String[] args) {
        System.out.println(calculate(10, 2));
        System.out.println(calculate(1, 0));
    }

    static int calculate(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("报错了： " + e.getMessage());
        } finally {
            System.out.println("进入了finally字句中");
        }

        return 0;
    }
}
