package com.demo.gateway.filter;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-2-23 10:19
 */
@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "globalFilter")
@Order(-1000)
public class GlobalFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info(JSONUtil.toJsonStr(request));
        filterChain.doFilter(request, response);
    }
}
