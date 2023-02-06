package cn.bravedawn;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2022/11/28 13:04
 */
public interface Repository {

    /**
     * 查询一条记录
     * @param args
     * @return
     * @param <T>
     * @throws Exception
     */
    <T> T selectOne(T args) throws Exception;


    /**
     * 保存一条记录
     * @param args
     * @return
     * @param <T>
     * @throws Exception
     */
    <T> long save(T args) throws  Exception;

    /**
     * 批量插入
     * @param list
     * @return
     * @param <T>
     */
    <T> long batchSave(List<T> list);
}
