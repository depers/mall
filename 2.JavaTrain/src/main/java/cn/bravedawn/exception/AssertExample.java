package cn.bravedawn.exception;

public class AssertExample {

    public static void main(String[] args) {
        int x = 1;
        assert x < 0 : "x must < 0";
        System.out.println(x);
    }
}
