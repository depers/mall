package cn.bravedawn.generic.bridgemethod;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/17 11:26
 */
public interface Parent<T> {

    T bridgeMethod(T param);

    // 类型擦除之后，这个类会变成这个样子
    // Object bridgeMethod(Object param);
}
