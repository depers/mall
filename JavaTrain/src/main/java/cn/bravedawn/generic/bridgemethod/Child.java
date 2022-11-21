package cn.bravedawn.generic.bridgemethod;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/17 11:29
 */
public class Child implements Parent<String>{


    @Override
    public String bridgeMethod(String param) {
        return param;
    }


    // 在Java编译器编译之后，这个类会生成类似下面的桥接方法。这个方法是为了保证和jdk1.5之前的字节码相兼容
    //public Object bridgeMethod(Object param) {
    //    return param;
    //}
}
