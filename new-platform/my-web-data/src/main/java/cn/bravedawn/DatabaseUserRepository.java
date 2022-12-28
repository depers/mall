package cn.bravedawn;

import cn.bravedawn.entity.Member;
import cn.bravedawn.util.MyStringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/12/26 21:50
 */
public class DatabaseUserRepository implements Repository<Member> {

    private static final String BLANK_SPACE = " ";
    private static final String COMMA = ",";

    private static final String QUOTATION_MARK = "'";

    private static final String SET_SQL = " SET ";
    private static Map<Class, String> resultSetMethodMappings = new HashMap<>();

    static {
        resultSetMethodMappings.put(Long.class, "getLong");
        resultSetMethodMappings.put(String.class, "getString");
        resultSetMethodMappings.put(Integer.class, "getInt");
    }


    @Override
    public Member selectOne(Member args) throws Exception {

        Member member = new Member();

        // 准备sql
        StringBuffer selectBuffer = new StringBuffer("SELECT");
        StringBuffer whereBuffer = new StringBuffer("WHERE");
        BeanInfo beanInfo = Introspector.getBeanInfo(Member.class, Object.class);
        Map<String, Object> columnMap = new HashMap<>();
        Map<String, Class> columnTypeMap = new HashMap<>();

        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            // 字段名
            String fieldName = descriptor.getName();
            // 字段类型
            Class fieldType = descriptor.getPropertyType();
            // 获取对象get方法
            Method getMethod = descriptor.getReadMethod();
            // 将字段名和字段值保存到map中
            columnMap.put(MyStringUtils.mapColumnLabel(fieldName), getMethod.invoke(args));
            columnTypeMap.put(fieldName, fieldType);
        }

        // 拼接查询sql
        for (Map.Entry<String, Object> entry : columnMap.entrySet()) {
            String key = entry.getKey();
            selectBuffer.append(BLANK_SPACE).append(key).append(COMMA);

            if (entry.getValue() != null) {
                String value = String.valueOf(entry.getValue());
                whereBuffer.append(BLANK_SPACE).append(key).append("=").append(value);
            }
        }
        selectBuffer.deleteCharAt(selectBuffer.length() - 1);

        // 最终sql
        String tableName = MyStringUtils.mapColumnLabel(Member.class.getSimpleName());
        selectBuffer.append(BLANK_SPACE).append("FROM").append(BLANK_SPACE).append("public." + tableName);
        if (whereBuffer.length() > 5) {
            selectBuffer.append(whereBuffer);
        }

        System.out.println("最终的sql：" + selectBuffer);

        Connection connection = DBConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        try(ResultSet resultSet = statement.executeQuery(selectBuffer.toString())) {
            if (resultSet.next()) {
                for (Map.Entry<String, Class> entry : columnTypeMap.entrySet()) {
                    System.out.println(entry.toString());
                    // 获取ResultSet的方法名
                    String methodName = resultSetMethodMappings.get(entry.getValue());
                    // 获取ResultSet的方法
                    Method resultMethod = ResultSet.class.getMethod(methodName, String.class);
                    // 使用反射获取数据库字段值
                    Object resultValue = resultMethod.invoke(resultSet, entry.getKey());
                    // 获取Member的setter方法
                    String setterMethodName = "set" + MyStringUtils.capitalize(entry.getKey());
                    Method setterMethodFromMember = Member.class.getMethod(setterMethodName, entry.getValue());
                    setterMethodFromMember.invoke(member, resultValue);
                }
            }

            return member;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public long save(Member args) throws Exception{
        StringBuffer insertBuffer = new StringBuffer("INSERT INTO");
        insertBuffer.append(BLANK_SPACE).append("public." + args.getClass().getSimpleName().toLowerCase()).append(SET_SQL);
        BeanInfo beanInfo = Introspector.getBeanInfo(Member.class, Object.class);

        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            // 字段名
            String fieldName = descriptor.getName();
            // 字段类型
            Class fieldType = descriptor.getPropertyType();
            // 获取对象get方法
            Method getMethod = descriptor.getReadMethod();

            // 获取属性的值
            Object value = getMethod.invoke(args);
            if (value != null && MyStringUtils.isNotBlank(String.valueOf(value))) {
                insertBuffer.append(MyStringUtils.mapColumnLabel(fieldName))
                        .append(" = ").append(getValueFromType(value)).append(COMMA).append(BLANK_SPACE);
            }
        }

        insertBuffer.deleteCharAt(insertBuffer.length() - 1).deleteCharAt(insertBuffer.length() - 1);

        System.out.println(insertBuffer);

        // 获取连接
        Connection connection = DBConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeLargeUpdate(insertBuffer.toString());
    }

    /**
     * 根据值的类型返回其在insert sql语句中的set值
     * @param val 对象的属性值
     * @return
     */
    private String getValueFromType(Object val) {
        if (val instanceof String) {
            return MyStringUtils.wrapperValue(String.valueOf(val), QUOTATION_MARK, QUOTATION_MARK);
        } else {
            return String.valueOf(val);
        }
    }


    public static void main(String[] args) throws Exception {
        DatabaseUserRepository databaseUserRepository = new DatabaseUserRepository();
        // Member member = databaseUserRepository.selectOne(new Member());
        // System.out.println(member);

        Member m = new Member();
        m.setUsername("fengxiao");
        m.setPassword("fx1212");
        m.setEmail("2368472130@qq.com");
        databaseUserRepository.save(m);
    }
}
