package cn.bravedawn.basic.flow;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/12 21:14
 */
public class SwitchExample {

    /**
     * switch基础语法
     */

    public static void main(String[] args) {
        int value = 1;

        switch (value) {
            case 1:
                System.out.println("switch 1");
                break;
            case 2:
                System.out.println("switch 2");
                break;
            default:
                System.out.println("switch default");
        }
    }
}
