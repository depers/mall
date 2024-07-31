package cn.bravedawn.requestparam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/7/31 17:06
 */

@Data
@AllArgsConstructor
public class User {

    private String username;
    private int age;
    private String gender;
}
