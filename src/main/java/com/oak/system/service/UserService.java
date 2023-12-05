package com.oak.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oak.system.entity.Roles;
import com.oak.system.entity.User;
import com.oak.vo.TokenVO;

public interface UserService extends IService<User> {

    /**
     * 登录
     */
    TokenVO login(User user);

    Roles info(String token);

    User getUser(String username);
}
