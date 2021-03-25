package cn.bravedawn.vo;

import cn.bravedawn.bo.ShopcartBO;
import lombok.Data;

import java.util.List;

@Data
public class OrderVO {

    private String orderId;

    private MerchantOrdersVO merchantOrdersVO;

    private List<ShopcartBO> toBeRemovedShopcartList;
}