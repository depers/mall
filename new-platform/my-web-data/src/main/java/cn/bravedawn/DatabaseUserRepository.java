package cn.bravedawn;

/**
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/12/26 21:50
 */
public class DatabaseUserRepository implements Repository {
    @Override
    public Object selectOne(String sql, Object... args) {
        return null;
    }

    @Override
    public int save(String sql, Object... args) {
        return 0;
    }
}
