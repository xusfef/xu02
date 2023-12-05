package com.oak.system.service.impl;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oak.common.JwtUtil;
import com.oak.exception.ParamException;
import com.oak.system.entity.Roles;
import com.oak.system.entity.User;
import com.oak.system.mapper.UserMapper;
import com.oak.system.service.UserService;
import com.oak.vo.TokenVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public TokenVO login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername()).eq("password", user.getPassword());

        User savedUser = getOne(queryWrapper);

        if (ObjectUtil.isEmpty(savedUser)) {
            throw new ParamException("用户名或密码错误");
        }

        String token = JwtUtil.createJwt(user.getUsername());
        return new TokenVO(savedUser.getId(), token);

    }

    @Override
    public Roles info(String token) {
        String roles = "admin";
        return new Roles(roles);
    }

    @Override
    public User getUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> user = queryWrapper.eq("username", username);
        return baseMapper.selectOne(queryWrapper);
    }
}
