package cn.bravedawn.springsecurity.service;

import cn.bravedawn.springsecurity.model.User;

public interface UserService {

    User getUserByName(String userName);
}
