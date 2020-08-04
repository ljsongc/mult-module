package com.song.api.filter;


import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jack
 * @date 2017/4/28
 */
@Order(1) //@Order注解表示执行过滤顺序，值越小，越先执行
@WebFilter(filterName = "loginFilter", urlPatterns = ("/*"))
//需要在spring-boot的入口处加注解@ServletComponentScan, 如果不指定，默认url-pattern是/*
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(request, response);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public void destroy() {

    }
}
