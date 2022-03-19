package cn.bravedawn.reflection.method;

public class ReflectionExample {

    /**
     * 获取类的方法信息
     */

    public static void main(String[] args) throws NoSuchMethodException {
        Class stdClass = Student.class;

        // 获取public 方法getScore，参数为String
        System.out.println(stdClass.getMethod("getScore", String.class));

        // 获取继承的public方法getName，无参数
        System.out.println(stdClass.getMethod("getName"));

        // 获取private方法getGrade，参数为int
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

    }
}
