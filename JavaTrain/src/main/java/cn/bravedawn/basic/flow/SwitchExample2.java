package cn.bravedawn.basic.flow;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/12 21:35
 */
public class SwitchExample2 {

    public static void main(String[] args) {

        /**
         * 用switch给某个变量赋值
         */

        int opt;
        int value = 3;
        switch (value) {
            case 1:
                System.out.println("switch 1");
                opt = 1;
                break;
            case 2:
                System.out.println("switch 2");
                opt = 2;
                break;
            default:
                System.out.println("switch default");
                opt = 3;
        }

        System.out.println(opt);
    }
}
