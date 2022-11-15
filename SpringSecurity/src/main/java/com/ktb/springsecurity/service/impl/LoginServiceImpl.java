package com.ktb.springsecurity.service.impl;

import com.ktb.springsecurity.entity.LoginUser;
import com.ktb.springsecurity.entity.User;
import com.ktb.springsecurity.response.ResponseResult;
import com.ktb.springsecurity.service.LoginServcie;
import com.ktb.springsecurity.util.JwtUtil;
import com.ktb.springsecurity.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginServcie {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("Authentication token");
        }
        LoginUser principal = (LoginUser) authenticate.getPrincipal();
        Long userId = principal.getUser().getId();
        String jwt = JwtUtil.createJWT(userId + "");
        redisCache.setCacheObject("login:"+userId,principal);
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("token", jwt);
        return ResponseResult.ok(result);
    }
}
