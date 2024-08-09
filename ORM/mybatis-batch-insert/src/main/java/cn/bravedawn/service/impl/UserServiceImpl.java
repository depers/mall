package cn.bravedawn.service.impl;

import cn.bravedawn.dao.UserMapper;
import cn.bravedawn.model.User;
import cn.bravedawn.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author : depers
 * @program : mybatis-batch-insert
 * @date : Created in 2024/8/9 23:09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
