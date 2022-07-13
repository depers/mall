package cn.bravedawn.obj.object;

public class ObjDefaultFieldReferenceType {

    /**
     * 一个类的 包装类型 字段的初始值都是null
     */

    private String str; // null

    private Character character; // null

    private Integer integer; // null

    private Float aFloat; // null

    private Double aDouble; // null

    private Long aLong; // null

    private Boolean aBoolean; // null

    private Byte aByte; // null

    private Short aShort; // null

    @Override
    public String toString() {
        return "ObjDefaultFieldType{" +
                "str='" + str + '\'' +
                ", character=" + character +
                ", integer=" + integer +
                ", aFloat=" + aFloat +
                ", aDouble=" + aDouble +
                ", aLong=" + aLong +
                ", aBoolean=" + aBoolean +
                ", aByte=" + aByte +
                ", aShort=" + aShort +
                '}';
    }

    public static void main(String[] args) {
        ObjDefaultFieldReferenceType type = new ObjDefaultFieldReferenceType();
        System.out.println(type.toString());
    }
}
