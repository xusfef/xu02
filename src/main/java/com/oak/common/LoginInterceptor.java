package com.oak.common;

import cn.hutool.json.JSONUtil;
import com.oak.system.entity.User;
import com.oak.system.service.UserService;
import com.oak.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public static final String OPTIONS = "OPTIONS";

    public static final String AUTHORIZATION = "X-Token";

    @Autowired
    UserService userService;

    /**
     * 1、放行OPTIONS请求(预检请求)
     * 2、检查请求头中有没有Authorization  没有就返回  有就继续
     * 3、验证token有没有过期   过期就返回   没有过期继续
     * 4、验证token里的username(userService.getUser(username))  没有就返回  有就允许访问接口
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* 1、放行OPTIONS请求(预检请求) */
        String method = request.getMethod();
        if (StringUtils.equalsIgnoreCase(method, OPTIONS)) {
            return true;
        }

        /* 2、检查请求头中有没有Authorization  没有就返回  有就继续 */
        String header = request.getHeader(AUTHORIZATION);
        if (StringUtils.isEmpty(header)) {
            return noAuth(response, "没有token！");
        }

        /* 3、验证token有没有过期   过期就返回   没有过期继续 */
        if (!JwtUtil.isExpire(header)) {
            return noAuth(response, "错误的token或token过期！");
        }

        /* 4、验证token里的username(userService.getUser(username))  没有就返回  有就允许访问接口 */
        String username = JwtUtil.getUsername(header);
        User user = userService.getUser(username);
        if (ObjectUtils.isEmpty(user)) {
            return noAuth(response, "token错误！");
        }

        return true;
    }

    private boolean noAuth(HttpServletResponse response, String msg) throws IOException {
        ResultVO<Object> resultVO = ResultVO.failed(401, msg);
        String json = JSONUtil.toJsonStr(resultVO);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(json);

        writer.flush();
        writer.close();
        return false;
    }
}
