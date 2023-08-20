package cn.bravedawn.io.formatting;

public class RootExample2 {

    /**
     * 格式化
     * @param args
     */


    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);

        System.out.format("The square root of %d is %f.%n", i, r);

    }
}
