package cn.bravedawn.java8.functionalinterfaces;

//@FunctionalInterface
public interface Converter<F, T> {

    /**
     * 功能接口
     */

    T convert(F from);
}
