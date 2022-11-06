package cn.bravedawn.orm;

import cn.bravedawn.domain.User;

import java.util.Collection;
import java.util.logging.Logger;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/11/6 20:32
 */
public class DatabaseUserRepository implements UserRepository{

    private static Logger logger = Logger.getLogger(DatabaseUserRepository.class.getName());

    public static final String INSERT_USER_DML_SQL =
            "INSERT INTO users(name,password,email,phoneNumber) VALUES " +
                    "(?,?,?,?)";

    public static final String QUERY_ALL_USERS_DML_SQL = "SELECT id,name,password,email,phoneNumber FROM users";


    @Override
    public Collection<User> getAll() {
        return null;
    }
}
