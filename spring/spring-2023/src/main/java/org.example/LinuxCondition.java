package org.example;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2. 获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3. 获取当前环境信息，它里面就封装了我们这个当前运行时的一些信息，包括环境变量，以及包括虚拟机的一些变量
        Environment environment = context.getEnvironment();
        // 4. 获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        System.out.println("\"property\" = " + property);
        if (property.contains("Mac OS")) {
            return true;
        }
        return false;
    }
}
