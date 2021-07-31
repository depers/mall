package cn.bravedawn.druid.service.impl;

import cn.bravedawn.druid.dao.RoleMapper;
import cn.bravedawn.druid.model.Role;
import cn.bravedawn.druid.service.DruidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : depers
 * @program : druid
 * @description: DruidService实现类
 * @date : Created in 2021/7/31 19:20
 */
@Service
public class DruidServiceImpl implements DruidService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public long selectKey() {
        Role role = new Role();
        role.setRoleName("test");
        role.setNote("selectKey");
        roleMapper.insertAndSelectKey(role);
        return role.getId();
    }
}
