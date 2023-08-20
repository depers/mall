package cn.bravedawn.service.center;

import cn.bravedawn.bo.center.CenterUserBO;
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

        /**
         * 修改用户信息
         * @param userId
         * @param centerUserBO
         */
        Users updateUserInfo(String userId, CenterUserBO centerUserBO);

        /**
         * 用户头像更新
         * @param userId
         * @param faceUrl
         * @return
         */
        Users updateUserFace(String userId, String faceUrl);
}
