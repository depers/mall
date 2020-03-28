package cn.bravedawn.vo;

import java.util.Date;
import java.util.List;

/**
 * 用户中心，我的订单列表VO
 * @Author 冯晓
 * @Date 2020/3/28 9:52
 */
public class MyOrdersVO {

    private String orderId;
    private Date createdTime;
    private Integer payMethod;
    private Integer realPayAmount;
    private Integer postAmount;
    private Integer isComment;
    private Integer orderStatus;

    private List<MySubOrderItemVO> subOrderItemList;
}
