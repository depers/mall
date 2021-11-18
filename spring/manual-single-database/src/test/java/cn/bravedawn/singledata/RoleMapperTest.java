package cn.bravedawn.singledata;

import cn.bravedawn.singledata.dao.RoleMapper;
import cn.bravedawn.singledata.entity.Role;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : depers
 * @program : manual-single-database
 * @description: dao测试
 * @date : Created in 2021/11/16 11:39
 */
@SpringBootTest
public class RoleMapperTest {

    private Logger log = LoggerFactory.getLogger(RoleMapperTest.class);

    @Autowired
    private RoleMapper roleMapper;


    @Test
    public void selectTest() {
        List<Role> roles = roleMapper.selectOneByRoleName("test");
        System.out.println(roles);
        log.info("role = {}", roles);
    }
}
