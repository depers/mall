package cn.bravedawn.util;

import com.google.common.base.CaseFormat;

/**
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/12/27 21:22
 */
public class MyStringUtils {


    /**
     * 将实体类的字段名称改为下换线模式
     * @param fieldName 实体类字段
     * @return
     */
    public static String mapColumnLabel(String fieldName) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
