package cn.bravedawn.java8.stream.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/11/14 17:04
 */
@FunctionalInterface
public interface ThrowableFunction<T, R> {


    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     * @throws Throwable if met with any error
     */
    R apply(T t) throws Throwable;


    default R execute(T t) {
        R result = null;
        try {
            result = apply(t);
        } catch (Throwable e) {
            throw new RuntimeException(e.getCause());
        }

        return result;
    }

}
