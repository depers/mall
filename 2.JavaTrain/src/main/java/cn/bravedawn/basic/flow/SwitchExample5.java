package cn.bravedawn.basic.flow;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/12 21:14
 */
public class SwitchExample5 {

    /**
     * switch的case语句可以同时包含多个值的判断
     */

    public static void main(String[] args) {
        testSwitch(1);
        testSwitch(3);
    }

    static void testSwitch(int value) {
        switch (value) {
            case 1, 3:
                System.out.println("switch 1 or 3");
                break;
            case 2:
                System.out.println("switch 2");
                break;
            default:
                System.out.println("switch default");
        }
    }
}
