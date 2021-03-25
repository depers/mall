package cn.bravedawn.bo;

import lombok.Data;

/**
 * @Author 冯晓
 * @Date 2020/1/16 18:48
 * @Title 用户新增或修改地址的BO
 */
@Data
public class AddressBO {

    private String addressId;
    private String userId;
    private String receiver;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;
}
