package cn.bravedawn.service.center;

import cn.bravedawn.pojo.Users;

/**
 * @Author 冯晓
 * @Date 2020/3/25 8:39
 */
public interface CenterUserService {

        /**
         * 根据用户id查询用户信息
         * @param userId
         * @return
         */
        Users queryUserInfo(String userId);
}
