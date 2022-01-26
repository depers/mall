package cn.bravedawn.obj.object;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 17:57
 */
public class EqualsExample2 {

    public static void main(String[] args) {

        // 对于基本类型：== 判断两个值是否相等，基本类型没有 equals() 方法
        int a = 1;
        int b = 1;
        System.out.println(a == b); // true

        // 对于引用类型：== 判断两个变量是否引用同一个对象（对象引用的地址），而 equals() 判断引用的对象是否等价
        Integer c = new Integer(1);
        Integer d = new Integer(1);

        System.out.println(c.equals(d)); // true
        System.out.println(c == d); // false

    }
}
