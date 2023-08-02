package cn.bravedawn.springsecurity.service.impl;

import cn.bravedawn.springsecurity.constant.RoleType;
import cn.bravedawn.springsecurity.model.Role;
import cn.bravedawn.springsecurity.model.User;
import cn.bravedawn.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserByName(String userName) {
        if (!"depers".equals(userName)) {
            throw new RuntimeException("用户不存在");
        }

        List<Role> roles = Arrays.asList(new Role(RoleType.USER));
        return new User(userName, passwordEncoder.encode("123456"), roles);
    }
}
