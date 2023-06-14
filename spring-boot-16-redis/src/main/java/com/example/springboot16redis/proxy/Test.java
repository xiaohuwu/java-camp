package com.example.springboot16redis.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserServiceImpl impl = new UserServiceImpl();
        UserProxy userProxy = new UserProxy(impl);
        Class<?>[] interfaces = impl.getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface = " + anInterface);
        }
//        Object newProxyInstance = Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), userProxy);
//        newProxyInstance.addUser();
//        userService.updateUser("：我是皮皮虾");

        Integer[] test = new Integer[]{1, 2, 3, 4};
        List<Integer> integers = new ArrayList<>(Arrays.asList(test));
        Integer[] objects = integers.toArray(new Integer[integers.size()]);
        System.out.println("objects = " + Arrays.toString(objects));
    }
}
