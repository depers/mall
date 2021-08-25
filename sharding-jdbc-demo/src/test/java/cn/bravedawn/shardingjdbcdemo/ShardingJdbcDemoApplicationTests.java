package cn.bravedawn.shardingjdbcdemo;

import cn.bravedawn.shardingjdbcdemo.dao.AreaMapper;
import cn.bravedawn.shardingjdbcdemo.dao.OrderItemMapper;
import cn.bravedawn.shardingjdbcdemo.dao.OrdersMapper;
import cn.bravedawn.shardingjdbcdemo.model.Area;
import cn.bravedawn.shardingjdbcdemo.model.AreaExample;
import cn.bravedawn.shardingjdbcdemo.model.OrderItem;
import cn.bravedawn.shardingjdbcdemo.model.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShardingJdbcDemoApplicationTests {

	@Autowired
	private OrdersMapper ordersMapper;

	@Autowired
    private AreaMapper areaMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void insert(){
		Orders orders = new Orders();

		orders.setOrderId(19);
		orders.setUserId(2);
		orders.setOrderAmount(BigDecimal.TEN);
		orders.setOrderStatus(0);

		// 插入目标数据库：192.168.156.139，表：orders_2
		ordersMapper.insert(orders);
	}

	@Test
    public void testGlobal() {
        Area area = new Area();
        area.setId(4);
        area.setName("兰州");
        areaMapper.insert(area);
    }

    @Test
	public void testSelectGlobal() {
		AreaExample areaExample = new AreaExample();
		areaExample.createCriteria().andIdEqualTo(4);
		List<Area> areaList = areaMapper.selectByExample(areaExample);
		System.out.println("area.size=" + areaList.size());
	}


	@Test
	public void testOrderItem() {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(4);
		orderItem.setOrderId(19);
		orderItem.setProductName("MacBook Air 笔记本");
		orderItem.setNum(1);
		orderItem.setUserId(2);
		orderItemMapper.insertSelective(orderItem);
	}



}
