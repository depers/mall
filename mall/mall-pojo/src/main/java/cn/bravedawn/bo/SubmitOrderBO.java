package cn.bravedawn.bo;

import lombok.Data;

/**
 * @Title 用于创建订单的BO对象
 * @Author 冯晓
 * @Date 2020/1/19 22:39
 */
@Data
public class SubmitOrderBO {

    private String userId;
    private String itemSpecIds;
    private String addressId;
    private Integer payMethod;
    private String leftMsg;
}
