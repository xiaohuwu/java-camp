package com.ktb;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("xiaohu") && password.equals("123456");
    }
}
