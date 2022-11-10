package cn.bravedawn.orm;

import cn.bravedawn.domain.User;
import cn.bravedawn.pojo.Role;
import com.mysql.jdbc.CacheAdapter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;

import static org.apache.commons.lang.ClassUtils.wrapperToPrimitive;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/11/6 20:32
 */
public class DatabaseUserRepository implements UserRepository{

    private static Logger logger = Logger.getLogger(DatabaseUserRepository.class.getName());
    private static Map<Class, String> preparedStatementMethodMappings = new HashMap();
    static Map<Class, String> resultSetMethodMappings = new HashMap<>();


    static {
        preparedStatementMethodMappings.put(Long.class, "setLong");
        preparedStatementMethodMappings.put(String.class, "setString");
        preparedStatementMethodMappings.put(Integer.class, "setInt");
        preparedStatementMethodMappings.put(Date.class, "setDate");

        resultSetMethodMappings.put(Long.class, "getLong");
        resultSetMethodMappings.put(String.class, "getString");
        resultSetMethodMappings.put(Integer.class, "getInt");
        resultSetMethodMappings.put(Date.class, "getDate");
    }


    public Collection<Role> getAll(String sql, Object... args) throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IntrospectionException {

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            Class argType = arg.getClass();

            Class wrapperType = wrapperToPrimitive(argType);
            if (wrapperType == null) {
                wrapperType = argType;
            }
            String methodName = preparedStatementMethodMappings.get(argType);
            Method method = PreparedStatement.class.getMethod(methodName, int.class, wrapperType);

            // 将参数值替换成查询语句中的?
            method.invoke(preparedStatement, i + 1, args);
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        BeanInfo roleBeanInfo = Introspector.getBeanInfo(Role.class, Object.class);

        // 写一个简单的ORM框架
        List<Role> roles = new ArrayList<>();
        while (resultSet.next()) {
            Role role = new Role();
            // ResultSetMetaData 元信息

            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("当前表的名称：" + metaData.getTableName(1));
            System.out.println("当前表的列数：" + metaData.getColumnCount());

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println("列名称：" + metaData.getColumnLabel(i) + ", 类型：" + metaData.getColumnClassName(i));
            }


            // ORM 映射核心思想：通过反射执行代码（性能相对开销大）
            for (PropertyDescriptor propertyDescriptor : roleBeanInfo.getPropertyDescriptors()) {
                String fieldName = propertyDescriptor.getName();
                Class fieldType = propertyDescriptor.getPropertyType();
                String methodName = resultSetMethodMappings.get(fieldType);

                // 若bean与数据库表字段存在映射关系，获取数据库字段名称
                String columnLabel = mapColumnLabel(fieldName);
                // 获取resultSet获取字段值的方法
                Method resultSetMethod = ResultSet.class.getMethod(methodName, String.class);
                // 使用反射获取数据库字段值
                Object resultValue = resultSetMethod.invoke(resultSet, columnLabel);
                // 获取bean该数据的setter方法
                Method setterMethodFromRole = propertyDescriptor.getWriteMethod();
                // 将数据库的值赋值给bean字段
                setterMethodFromRole.invoke(role, resultValue);
            }
            roles.add(role);
        }
        return roles;
    }



    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useSSL=false", "root", "fx1212");
        return connection;
    }

    private static String mapColumnLabel(String fieldName) {
        return fieldName;
    }


    @Override
    public Collection<Role> getAll() throws Throwable {
        String sql = "SELECT id, role_name, `type`, note, insert_time FROM `role` where type = ?";
        return getAll(sql, 2);
    }


    public static void main(String[] args) throws Throwable {
        UserRepository userRepository = new DatabaseUserRepository();
        Collection<Role> roles = userRepository.getAll();

        System.out.println(roles);
    }
}
