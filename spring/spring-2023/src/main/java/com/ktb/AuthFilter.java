package com.ktb;

import com.ktb.controller.UserController;
import com.ktb.model.User;
import com.ktb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@Slf4j
public class AuthFilter implements Filter {
    @Autowired
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse back = (HttpServletResponse) response;
        try {
            if (req.getRequestURI().contains("/signin")) {
                chain.doFilter(request, response);
                return;
            }
            authenticateByHeader(req);
            chain.doFilter(request, response);
        } catch (RuntimeException e) {
            log.warn("login by authorization header failed.", e);
            back.sendRedirect("/signin");
        }

    }

    @Override
    public void destroy() {

    }


    private void authenticateByHeader(HttpServletRequest req) throws UnsupportedEncodingException {
        String authHeader = req.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            log.info("try authenticate by authorization header...");
            String up = new String(Base64.getDecoder().decode(authHeader.substring(6)), StandardCharsets.UTF_8);
            int pos = up.indexOf(':');
            if (pos > 0) {
                String email = URLDecoder.decode(up.substring(0, pos), "UTF-8");
                String password = URLDecoder.decode(up.substring(pos + 1), "UTF-8");
                User user = userService.signin(email, password);
                req.getSession().setAttribute(UserController.KEY_USER, user);
                log.info("user {} login by authorization header ok.", email);
            }
        }
    }



}
