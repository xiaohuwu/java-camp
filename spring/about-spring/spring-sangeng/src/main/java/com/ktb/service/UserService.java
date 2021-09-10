package com.ktb.service;
import com.ktb.config.InvokeLog;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @InvokeLog
    public Integer deleteAll(){
        System.out.println("UserService中deleteAll的核心代码");
        int result = 1/ 0 ;
        return 3;
    }

}
