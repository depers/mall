package cn.bravedawn.service;

import cn.bravedawn.bo.SubmitOrderBO;

/**
 * @Author 冯晓
 * @Date 2020/1/19 22:56
 */
public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    String createOrder(SubmitOrderBO submitOrderBO);


}
