package cn.bravedawn;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2022/11/28 13:04
 */
public interface Repository<T> {

    T selectOne(String sql, Object ...args);

    int save(String sql, Object ...args);
}
