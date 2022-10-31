package com.ktb.newbee;

import cn.hutool.crypto.SecureUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewbeeApplicationTests {

	@Test
	void contextLoads() {
		String md5Str = SecureUtil.md5("123456");
		System.out.println(md5Str);
	}

}
