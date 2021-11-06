package cn.bravedawn.jackson.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 测试dto
 * @date : Created in 2021/11/6 10:22
 */
public class MyDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stringValue;

    private int intValue;

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}
