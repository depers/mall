package cn.bravedawn.orm;

import cn.bravedawn.pojo.Role;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/11/6 20:35
 */
public interface UserRepository {


    Collection<Role> getAll() throws Throwable;

}
