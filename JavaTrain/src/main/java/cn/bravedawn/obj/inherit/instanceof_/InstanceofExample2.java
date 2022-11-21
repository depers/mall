package cn.bravedawn.obj.inherit.instanceof_;

public class InstanceofExample2 {

    /**
     * Java 14 带来了新版的 instanceof 操作，将参数类型检查和绑局部变量类型合并到了一起
     */

    public static void main(String[] args) {
        Object obj = "hello";
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.toUpperCase());
        }

        // Java 14 带来了新版的 instanceof 操作，将参数类型检查和绑局部变量类型合并到了一起
        if (obj instanceof String str) {
            System.out.println(str.toUpperCase());
        }
    }
}
