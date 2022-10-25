package cn.bravedawn.orm;

import cn.bravedawn.pojo.Role;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/10/25 20:44
 */
public class OrmExample {

    /**
     * 数据类型与 ResultSet 方法名映射
     */
    static Map<Class, String> typeMethodMappings = new HashMap<>();

    static {
        typeMethodMappings.put(Integer.class, "getInt");
        typeMethodMappings.put(String.class, "getString");
        typeMethodMappings.put(LocalDateTime.class, "getTimestamp");

    }


    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useSSL=false", "root", "fx1212");

        Statement statement = connection.createStatement();

        // 执行查询语句
        ResultSet resultSet = statement.executeQuery("SELECT id, role_name, `type`, note, insert_time FROM `role`");

        BeanInfo roleBeanInfo = Introspector.getBeanInfo(Role.class, Object.class);

        for (PropertyDescriptor propertyDescriptor : roleBeanInfo.getPropertyDescriptors()) {
            System.out.println(propertyDescriptor.getName() + ", " + propertyDescriptor.getPropertyType());
        }

        // 写一个简单的ORM框架
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
                String methodName = typeMethodMappings.get(fieldType);
                System.out.println("-----------" + fieldName + "-------------" + methodName);

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

                //resultSet.getInt()
            }

            System.out.println(role);

        }


    }

    private static String mapColumnLabel(String fieldName) {
        return fieldName;
    }
}
