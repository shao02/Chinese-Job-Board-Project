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
        if ("GET".equals(((HttpServletRequest) servletRequest).getMethod())
                || "POST".equals(((HttpServletRequest) servletRequest).getMethod())) {
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "http://localhost");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTIONS");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Content-Type,Authorization");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Max-Age", "1800");//30 min
            filterChain.doFilter(servletRequest, servletResponse);
        }else if("OPTIONS".equals(((HttpServletRequest) servletRequest).getMethod())){
            if (servletResponse instanceof HttpServletResponse) {
                ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "http://localhost");
                ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTIONS");
                ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Content-Type,Authorization");
                ((HttpServletResponse) servletResponse).addHeader("Access-Control-Max-Age", "1800");//30 min
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse
                        .setStatus(HttpServletResponse.SC_OK);
            }
        }
    }



    @Override
    public void destroy() {
    }
}