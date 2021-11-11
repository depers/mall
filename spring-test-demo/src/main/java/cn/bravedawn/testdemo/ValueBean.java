package cn.bravedawn.testdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : manual-single-database
 * @description:
 * @date : Created in 2021/11/11 17:48
 */

@Component
public class ValueBean {

    @Value("${spring.datasource.single.username:1212}")
    private String dbName;


    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
