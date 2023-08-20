package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2021/12/25 21:47
 */
public class BooleanExample {


    private boolean isBool;

    public boolean getIsBool() {
        return isBool;
    }

    public void setBool(boolean bool) {
        isBool = bool;
    }

    public static void main(String[] args) {
        BooleanExample booleanExample = new BooleanExample();
        System.out.println(booleanExample.isBool);
    }
}
