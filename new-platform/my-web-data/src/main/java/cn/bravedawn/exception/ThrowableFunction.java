package cn.bravedawn.exception;

/**
 * 异常处理类
 *
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/11/24 22:29
 */
@FunctionalInterface
public interface ThrowableFunction<T, R> {

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
