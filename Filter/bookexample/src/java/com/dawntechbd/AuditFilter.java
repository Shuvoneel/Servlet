package com.dawntechbd;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AuditFilter implements Filter {

    private FilterConfig filterConfig = null;

    public AuditFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        String remoteAddress = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        HttpServletRequest req = (HttpServletRequest) request;
        String regURI = req.getRequestURI();
        chain.doFilter(request, response);
        filterConfig.getServletContext().log("User at IP: " + remoteAddress + "(" + remoteHost + ") accessed resource " + regURI + " and used " + (System.currentTimeMillis() - startTime) + " ms");
    }

    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
