package cn.bravedawn.service;

import cn.bravedawn.bo.SubmitOrderBO;
import cn.bravedawn.vo.OrderVO;

/**
 * @Author 冯晓
 * @Date 2020/1/19 22:56
 */
public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    OrderVO createOrder(SubmitOrderBO submitOrderBO);

    /**
     * 修改订单状态
     * @param orderId
     * @param orderStatus
     */
    public void updateOrderStatus(String orderId, Integer orderStatus);

}
