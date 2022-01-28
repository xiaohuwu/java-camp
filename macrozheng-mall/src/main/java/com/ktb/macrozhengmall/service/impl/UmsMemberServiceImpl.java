package com.ktb.macrozhengmall.service.impl;

import com.ktb.macrozhengmall.common.api.CommonResult;
import com.ktb.macrozhengmall.service.RedisService;
import com.ktb.macrozhengmall.service.UmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Slf4j
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    RedisService redisService;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int k = new Random().nextInt(9);
            sb.append(k);
        }
        redisService.set("code_"+telephone, sb.toString());
        return CommonResult.success(sb.toString());
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        String s = redisService.get("code_" + telephone);
        log.info("redis code: {}",s);
        return CommonResult.success(authCode.equals(s));
    }

}
