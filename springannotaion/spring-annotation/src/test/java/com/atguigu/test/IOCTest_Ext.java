package com.atguigu.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.ext.ExtConfig;

public class IOCTest_Ext {
	private static final Logger logger = LoggerFactory.getLogger(IOCTest_Ext.class);
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);
		logger.info("Application started with INFO level");

		//发布事件；
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
		});

		applicationContext.close();
	}

}
