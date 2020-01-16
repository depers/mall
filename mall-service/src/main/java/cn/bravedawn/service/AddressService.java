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

    /**
     * 用户修改地址
     * @param addressBO
     */
    void updateUserAddress(AddressBO addressBO);

    /**
     * 根据用户id和地址id，删除对应的用户地址信息
     * @param userId
     * @param addressId
     */
    void deleteUserAddress(String userId, String addressId);

    /**
     * 修改默认地址
     * @param userId
     * @param addressId
     */
    void updateUserAddressToBeDefault(String userId, String addressId);
}