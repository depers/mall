package cn.bravedawn.reflection.inherit;

public class ReflectionExample2 {

    /**
     * 获取interface
     * 要特别注意：getInterfaces()只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型
     */


    public static void main(String[] args) {
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
    }
}
