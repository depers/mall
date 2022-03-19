package cn.bravedawn.reflection.field;

public class ReflectionExample {

    /**
     * 获取类的字段信息
     */

    public static void main(String[] args) throws NoSuchFieldException {
        Class stdClass = Student.class;

        // 获取public字段 score
        System.out.println(stdClass.getField("score"));

        // 获取继承的public字段 name
        System.out.println(stdClass.getField("name"));

        // 获取private字段 grade
        System.out.println(stdClass.getDeclaredField("grade"));
    }
}
