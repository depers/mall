package cn.bravedawn.basic.flow;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/12 21:35
 */
public class SwitchExample3 {

    public static void main(String[] args) {

        /**
         * Java14：switch语句正式升级为表达式，不再需要break
         */

        int opt;
        int value = 3;
        switch (value) {
            case 1:
                System.out.println("switch 1");
                opt = 1;
            case 2:
                System.out.println("switch 2");
                opt = 2;
            default:
                System.out.println("switch default");
                opt = 3;
        }

        System.out.println(opt);
    }
}
