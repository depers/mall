package cn.bravedawn.orm;

import cn.bravedawn.domain.User;

import java.util.Collection;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/11/6 20:35
 */
public interface UserRepository {


    Collection<User> getAll();

}
