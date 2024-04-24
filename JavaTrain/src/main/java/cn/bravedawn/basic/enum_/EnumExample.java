package cn.bravedawn.basic.enum_;

public class EnumExample {

    /**
     * 枚举的比较
     */

    public static void main(String[] args) {

        Color red = Color.RED;

        // 推荐使用
        System.out.println(red == Color.RED);

        /**
         * 之前我们说过引用类型的比较使用equals方法，如果使用==，则是比较两个引用类型的变量是否是同一个对象。但是enum类型例外，他使用==和基本类型是一样的，所以equals方法不推荐使用
         */
        System.out.println(red.equals(Color.RED));
    }
}
