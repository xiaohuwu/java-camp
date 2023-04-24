package com.ktb.xuefeng.ioc;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(OnSmtpEnvCondition.class)
public class SmtpMailService {

}
