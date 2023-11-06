package cn.bravedawn.collection.stack;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-03 15:30
 */
public class StackExample2 {

    /**
     * 使用场景：JVM在处理Java方法调用的时候就会通过栈这种数据结构维护方法调用的层次
     * 测试无限递归调用
     * 因为方法调用栈有容量的限制，嵌套调用过多会造成栈溢出，即引发StackOverflowError
     */


    public static void main(String[] args) {
        increase(1);
    }

    public static int increase(int x) {
        return increase(x) + 1;
    }
}
