package com.ktb.macrozhengmall.service;

import com.ktb.macrozhengmall.common.api.CommonResult;


public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
