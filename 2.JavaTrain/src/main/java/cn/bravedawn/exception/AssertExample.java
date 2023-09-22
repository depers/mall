package cn.bravedawn.exception;

public class AssertExample {

    /**
     * 因为断言会抛出AssertionError，造成程序结束退出。断言的使用，断言适用于开发和测试环境，生产环境不适用。
     * 这是因为JVM默认关闭断言指令，即遇到assert语句就自动忽略了，不执行。
     * 要执行assert语句，必须给Java虚拟机传递 -enableassertions（可简写为-ea）参数启用断言。
     */

    public static void main(String[] args) {
        int x = 1;
        assert x < 0 : "x must < 0";
        System.out.println(x);
    }
}
