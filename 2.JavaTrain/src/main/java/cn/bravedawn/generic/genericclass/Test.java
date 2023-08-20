package cn.bravedawn.generic.genericclass;

public class Test {

    /**
     * 泛型类的使用
     * 注意：
     *      1.泛型的类型参数只能是引用类型，不能是原始类型
     */

    public static void main(String[] args) {

        // 在使用泛型的时候传入泛型实参，就会根据泛型实参对具体参数进行类型限制
        Generic<Integer> genericInteger = new Generic<>(123456);
        Generic<String> genericString = new Generic<>("keyValue");
        System.out.println("泛型测试，key is " + genericInteger.getKey());
        System.out.println("泛型测试，key is " + genericString.getKey());

        // 在使用泛型实参的时候不传泛型实参，在泛型类中使用的泛型方法或成员变量定义的类型可以为任何类型
        Generic generic = new Generic("1111");
        Generic generic1 = new Generic(55.21);
        Generic generic2 = new Generic(4444);
        Generic generic3 = new Generic(true);

        System.out.println("泛型测试，key is " + generic.getKey());
        System.out.println("泛型测试，key is " + generic1.getKey());
        System.out.println("泛型测试，key is " + generic2.getKey());
        System.out.println("泛型测试，key is " + generic3.getKey());


        // 泛型类型使用instanceof操作
        System.out.println(genericInteger instanceof Generic<Integer>); // true
    }
}
