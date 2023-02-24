package cn.bravedawn.orm;

import cn.bravedawn.domain.User;
import com.google.common.base.CaseFormat;

import javax.sql.DataSource;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : depers
 * @program : jdbc-demo
 * @description:
 * @date : Created in 2023/2/23 21:47
 */
public class JDBCRepositoryImpl<T> implements JDBCRepository<T> {


    private static final String SQL_BLANK = " ";
    private static final String SQL_COMMA = ",";
    private static final String SQL_WHERE = "WHERE ";
    private static final String SQL_FROM = "FROM ";
    private static final String SQL_EQUALS = "=";


    private static Map<Class, String> resultSetMethodMappings = new HashMap<>();
    private Map<Class, Map<String, Class>> sqlCacheMap = new HashMap<>();



    static {
        resultSetMethodMappings.put(Long.class, "getLong");
        resultSetMethodMappings.put(String.class, "getString");
        resultSetMethodMappings.put(Integer.class, "getInt");
        resultSetMethodMappings.put(Date.class, "getDate");
    }


    private DataSource dataSource;



    @Override
    public List<T> selectList(Class entityClass, Object... args) {
        // select id, username, password, phone_number from mall_user where id = #{}, username = #{}
        StringBuilder sql = new StringBuilder("SELECT ");


        try {
            // 获取对象的所有字段和表名
            BeanInfo beanInfo = Introspector.getBeanInfo(entityClass, Object.class);

            String tableName = mapColumnLabel(entityClass.getSimpleName());

            // ORM 映射核心思想：通过反射执行代码（性能相对开销大）
            Map<String, Class> fieldsMap = new HashMap<>();
            for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                String fieldName = propertyDescriptor.getName();
                Class fieldType = propertyDescriptor.getPropertyType();
                // 缓存对象字段名称和类型
                fieldsMap.put(fieldName, fieldType);

                // 若bean与数据库表字段存在映射关系，获取数据库字段名称
                String columnLabel = mapColumnLabel(fieldName);
                sql.append(columnLabel).append(SQL_COMMA).append(SQL_BLANK);
            }

            // 构建SQL指令
            String fieldSql = sql.substring(0, sql.length() - 2);
            fieldSql = fieldSql + SQL_BLANK + SQL_FROM + tableName;
            System.out.println(fieldSql);

            // 解析where条件
            Method selectListMethod = this.getClass().getMethod("selectList", Class.class, Object[].class);
            Parameter[] parameters = selectListMethod.getParameters();
            System.out.println(parameters.length);
            for (int i = 1; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                Param annotation = parameter.getAnnotation(Param.class);
                String column = "";
                if (annotation != null) {
                    column = annotation.value();
                } else {
                    throw new IllegalArgumentException();
                }
                System.out.println(args);
                String value = String.valueOf(args[i]);
                fieldSql = fieldSql + SQL_BLANK + SQL_WHERE + SQL_BLANK + column + SQL_EQUALS + value;
            }

            System.out.println(fieldSql);


            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }



        return null;
    }

    @Override
    public int insertSelective(T entity) {
        return 0;
    }

    @Override
    public int insertBatch(List<T> entities) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(long id) {
        return 0;
    }

    @Override
    public int updateByIdSelective(T entity) {
        return 0;
    }

    /**
     * 获取数据库链接
     * @return
     */
    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过
     * @param fieldName
     * @return
     */
    private static String mapColumnLabel(String fieldName) {
        String columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
        return columnName;
    }


    public static void main(String[] args) {
        JDBCRepository repository = new JDBCRepositoryImpl();
        repository.selectList(User.class, "1");
    }
}