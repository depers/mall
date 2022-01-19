package cn.bravedawn.basic.flow;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/12 21:35
 */
public class SwitchExample4 {

    public static void main(String[] args) {

        /**
         * Java12：switch语句升级为更简洁的表达式语法，
         * 使用 -> 不需要使用break就可保证只有一条路径可以被执行
         */

        int opt;
        int value = 3;
        switch (value) {
            case 1 -> {
                System.out.println("switch 1");
                opt = 1;
            }
            case 2 -> {
                System.out.println("switch 2");
                opt = 2;
            }
            default -> {
                System.out.println("switch default");
                opt = 3;
            }
        }

        System.out.println(opt);
    }
}
