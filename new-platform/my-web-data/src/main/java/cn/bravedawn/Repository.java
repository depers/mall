package cn.bravedawn;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2022/11/28 13:04
 */
public interface Repository<T> {

    T selectOne(T args) throws Exception;

    long save(T args) throws IntrospectionException, InvocationTargetException, IllegalAccessException, Exception;
}
