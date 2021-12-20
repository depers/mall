package cn.bravedawn.java8.virtualextensionmethods;

public interface Formula {

    /**
     * 默认方法（虚拟扩展方法）
     * @param a
     * @return
     */

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
