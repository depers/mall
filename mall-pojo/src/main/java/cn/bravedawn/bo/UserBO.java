package cn.bravedawn.bo;

import lombok.Data;

/**
 * @Author 冯晓
 * @Date 2020/1/3 20:09
 */
@Data
public class UserBO {

    private String username;

    private String password;

    private String confirmPassword;
}
