package cn.bravedawn.generic.constructor;

public class ConstructorExample {

    /**
     * 泛型在构造函数上的使用
     */


    public <T extends Number> ConstructorExample(T t) {
        Integer a = (Integer) t;
        System.out.println("加1后的结果：" + (a + 1));
    }

    public static void main(String[] args) {
        ConstructorExample example = new ConstructorExample(1);

    }
}
