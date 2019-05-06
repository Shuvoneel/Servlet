package com.dawntechbd;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter2 implements Filter {

    private FilterConfig filterConfig = null;

    public SimpleFilter2() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        filterConfig.getServletContext().log("in SimpleFilter2");
        chain.doFilter(request, response);
        filterConfig.getServletContext().log("Leaving SimpleFilter2");
    }

    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

}
