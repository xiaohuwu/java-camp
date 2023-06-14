package com.example.springboot16redis;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        //public Class<?> loadClass(String name) throws ClassNotFoundException {
        //name = 包名 + 类名
        try {
            // User.class
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            InputStream is = getClass().getResourceAsStream(fileName);
            if (is == null) {
                throw new ClassNotFoundException(name);
            }
            byte[] b = new byte[is.available()];
            is.read(b);

            return defineClass(name, b, 0, b.length); // definclass() 把字节码转化为java.lang.Class；
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();

        Class clazz = myClassLoader.findClass("com.example.springboot16redis.User");
        System.out.println(clazz.getClassLoader());
        Object instance = clazz.newInstance();
        System.out.println(instance);

        System.out.println(User.class.getClassLoader());
        Class claz2 = User.class;
        Object o2 = claz2.newInstance();
        System.out.println(o2);
        System.out.println(instance.equals(o2));
    }
}
