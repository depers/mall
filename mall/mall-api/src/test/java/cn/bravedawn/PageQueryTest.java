package cn.bravedawn;

import cn.bravedawn.service.ItemService;
import cn.bravedawn.utils.PagedGridResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 冯晓
 * @Date 2020/4/2 10:45
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PageQueryTest {

    @Autowired
    private ItemService service;


    @Test
    public void testPageQuery(){
        // 共4 浦惠1 取3
        PagedGridResult result = service.searchItems("好吃", "desc", 1, 4);
        System.out.println(result.toString());

        System.out.println("---------------------------------------------------------");

        PagedGridResult result2 = service.searchItems("好吃", "desc", 2, 4);
        System.out.println(result2.toString());
    }
}
