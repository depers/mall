package cn.bravedawn.mapper;

import cn.bravedawn.pojo.Role;

import java.util.List;

/**
 * @author : depers
 * @program : pagehelper
 * @description:
 * @date : Created in 2022/1/4 17:44
 */
public interface RoleMapper {

    List<Role> selectListByRoleName(String roleName);
}
