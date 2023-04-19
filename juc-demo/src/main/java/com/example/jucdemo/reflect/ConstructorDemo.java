package com.example.jucdemo.reflect;





import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ConstructorDemo {

    public void hello( @Range(max=5) String name, String prefix) {
    }
    public static void main(String[] args) throws NoSuchMethodException {
        ConstructorDemo constructorDemo = new ConstructorDemo();
        Method hello = constructorDemo.getClass().getMethod("hello", String.class, String.class);
        Annotation[][] parameterAnnotations = hello.getParameterAnnotations();
        for (Annotation[] annotations : parameterAnnotations) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof Range ) {
                    Range range = (Range) annotation;
                    int max = range.max();
                    System.out.println("max = " + max);
                }
            }
        }
    }

}
