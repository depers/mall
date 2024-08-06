package cn.bravedawn.requestparam.dto;

import lombok.Data;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/8/1 16:27
 */

@Data
public class UserQueryDTO {

    private String username;
    private String age;
    private String gender;
}
