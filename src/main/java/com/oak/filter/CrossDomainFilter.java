package com.oak.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossDomainFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 允许哪些源
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

        // 允许哪些方法
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,PUT,DELETE");

        // 允许哪些请求头
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");

        // 设置预检请求过期时间
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");

        chain.doFilter(request, httpServletResponse);
    }
}
