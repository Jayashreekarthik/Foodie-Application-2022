package com.niit.ApiGateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerJwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String authHeader=request.getHeader("authorization");

        if(authHeader==null||!authHeader.startsWith("Bearer"))
        {
            throw new ServletException("Missing header");
        }
        String token=authHeader.substring(7);
        Claims claim= Jwts.parser().setSigningKey("customerkey").parseClaimsJws(token).getBody();
        request.setAttribute("Claims",claim);
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
