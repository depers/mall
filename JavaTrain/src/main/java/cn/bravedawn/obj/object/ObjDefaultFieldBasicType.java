package cn.bravedawn.obj.object;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/7/13 21:21
 */
public class ObjDefaultFieldBasicType {

    /**
     * 一个类的 基本数据类型 字段的初始值
     */


    private int anInt; // 0

    private byte aByte; // 0

    private short aShort; // 0

    private boolean aBoolean; // false

    private long aLong; // 0

    private float aFloat; // 0.0

    private double aDouble; // 0.0

    private char aChar; // nul

    @Override
    public String toString() {
        return "ObjDefaultFieldBasicType{" +
                "anInt=" + anInt +
                ", aByte=" + aByte +
                ", aShort=" + aShort +
                ", aBoolean=" + aBoolean +
                ", aLong=" + aLong +
                ", aFloat=" + aFloat +
                ", aDouble=" + aDouble +
                ", aChar=" + (int)aChar +
                '}';
    }


    public static void main(String[] args) {
        ObjDefaultFieldBasicType basicType = new ObjDefaultFieldBasicType();
        System.out.println(basicType.toString());
    }
}
