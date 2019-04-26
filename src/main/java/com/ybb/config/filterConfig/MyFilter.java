package com.ybb.config.filterConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //打印请求Url
        System.out.println("拦截器请求路径：" + request.getRequestURI()+"-------"+"请求IP地址："+request.getRemoteAddr());
        System.out.println("当前访问用户："+((HttpServletRequest) servletRequest).getSession().getAttribute("userName"));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
