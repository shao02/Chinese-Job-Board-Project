package com.chinese.jobs.filter;

/**
 * Created by xu_s on 12/25/15.
 */

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class corsFilterHeader implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if ( "OPTIONS".equals(((HttpServletRequest) servletRequest).getMethod()) ||
                "GET".equals(((HttpServletRequest) servletRequest).getMethod())) {
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "http://localhost/");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Content-Type");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Max-Age", "1800");//30 min
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}