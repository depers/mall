package cn.bravedawn.generic.typeerasure;

public class GenericType <T>{

    /**
     * 解决泛型的类型信息由于擦除无法进行类型判断的问题
     */

    Class<?> classType;

    public GenericType(Class<?> type) {
        classType=type;
    }

    public boolean isInstance(Object object) {
        return classType.isInstance(object);
    }

    public static void main(String[] args) {
        GenericType<String> g1 = new GenericType<>(String.class);
        GenericType<Integer> g2 = new GenericType<>(Integer.class);

        System.out.println(g1.isInstance(g2)); // false
    }

}
