package cn.bravedawn.service;

import cn.bravedawn.bo.UserBO;
import cn.bravedawn.pojo.Users;

/**
 * @Author 冯晓
 * @Date 2020/1/3 19:33
 */
public interface UserService {


    /**
     * 校验用户是否存在
     */
    boolean queryUserNameIsExist(String username);

    /**
     * 用户注册
     * @param userBO
     * @return
     */
    Users createUser(UserBO userBO);
}
