package cn.bravedawn.service;

import cn.bravedawn.bo.AddressBO;
import cn.bravedawn.pojo.UserAddress;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/16 18:34
 */
public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     * @param userId
     * @return
     */
    List<UserAddress> queryAll(String userId);

    /**
     * 用户新增地址
     * @param addressBO
     */
    void addNewUserAddress(AddressBO addressBO);
}
