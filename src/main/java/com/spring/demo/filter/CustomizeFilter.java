package com.spring.demo.filter;

import com.spring.demo.wrapper.CustomizeHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName CustomizeFilter
 * @Author leichen.china@gmail.com
 * @Date 2019-08-21 17:27
 * @Describe TODO
 */
@WebFilter(urlPatterns = "/*", filterName = "customizeFilter")
public class CustomizeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getHeader("Content-Type").contains("json")) {
                chain.doFilter(new CustomizeHttpServletRequestWrapper((HttpServletRequest) request), response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

}
