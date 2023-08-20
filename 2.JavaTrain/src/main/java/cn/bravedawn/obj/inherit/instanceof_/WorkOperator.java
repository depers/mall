package cn.bravedawn.obj.inherit.instanceof_;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/17 11:58
 */
public interface WorkOperator {

    default void learn() {
        System.out.println("我在学习");
    }
}
