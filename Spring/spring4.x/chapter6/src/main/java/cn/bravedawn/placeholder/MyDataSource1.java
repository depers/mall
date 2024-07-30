package cn.bravedawn.placeholder;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author : depers
 * @description :
 * @program : 1.spring4.x
 * @date : Created in 2023/9/17 17:49
 */
public class MyDataSource1 {

    private String driverClassName;

    private String url;

    private String userName;

    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
