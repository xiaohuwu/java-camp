package com.example.dockerdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ModelFactory;

@SpringBootTest
class DockerDemoApplicationTests {

    @Test
    void contextLoads() {
//        //  Prepare one HandlerMethod
//        HandlerMethod handlerMethod = new HandlerMethod(new Person(), getPersonSpecfyMethod());
//        //  Get all the parameters of this method
//        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
//        for (MethodParameter parameter : methodParameters) {
//            Class parameterType = parameter.getParameterType();
//            String nameForParameter = ModelFactory.getNameForParameter(parameter);
//            System.out.println(" type " + parameterType.getName() + "---> Default modelKey yes ：" + nameForParameter);
//        }
    }

}
