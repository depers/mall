package cn.bravedawn.service.impl.center;

import cn.bravedawn.mapper.OrdersMapperCustom;
import cn.bravedawn.service.center.MyOrdersService;
import cn.bravedawn.utils.PagedGridResult;
import cn.bravedawn.vo.MyOrdersVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 冯晓
 * @Date 2020/3/28 9:55
 */

@Service
public class MyOrdersServiceImpl extends BaseService implements MyOrdersService {

    @Autowired
    public OrdersMapperCustom ordersMapperCustom;

    @Override
    public PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        if (orderStatus != null) {
            map.put("orderStatus", orderStatus);
        }

        PageHelper.startPage(page, pageSize);

        List<MyOrdersVO> list = ordersMapperCustom.queryMyOrders(map);

        return setterPagedGrid(list, page);
    }
}
