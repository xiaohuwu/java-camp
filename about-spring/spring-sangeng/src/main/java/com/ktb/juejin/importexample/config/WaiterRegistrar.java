package com.ktb.juejin.importexample.config;

import com.ktb.juejin.importexample.model.Waiter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class WaiterRegistrar  implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean definition2 = registry.containsBeanDefinition("com.atguigu.bean.Blue");
        // 这里面的条件判断更加灵活
        registry.registerBeanDefinition("waiter", new RootBeanDefinition(Waiter.class));
    }
}
