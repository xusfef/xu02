package com.oak.system.controller;

import com.oak.system.entity.Roles;
import com.oak.system.entity.User;
import com.oak.system.service.UserService;
import com.oak.vo.ResultVO;
import com.oak.vo.TokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody User user) {
        TokenVO tokenVO = userService.login(user);
        return ResultVO.success(tokenVO);
    }

    @GetMapping("/info")
    public ResultVO info(@RequestParam String token) {
        Roles info = userService.info(token);
        return ResultVO.success(info);
    }
}
