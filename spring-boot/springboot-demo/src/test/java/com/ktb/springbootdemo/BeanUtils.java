package com.ktb.springbootdemo;

import com.ktb.springbootdemo.IGetter;
import com.ktb.springbootdemo.ISetter;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class BeanUtils {

    /***
     * 转换方法引用为属性名
     * @param fn
     * @return
     */
    public static <T> String convertToFieldName(IGetter<T> fn) {
        SerializedLambda lambda = getSerializedLambda(fn);
        String methodName = lambda.getImplMethodName();
        String prefix = null;
        if(methodName.startsWith("get")){
            prefix = "get";
        }
        else if(methodName.startsWith("is")){
            prefix = "is";
        }
        if(prefix == null){

        }
        // 截取get/is之后的字符串并转换首字母为小写（S为diboot项目的字符串工具类，可自行实现）
        return methodName;
    }

    /***
     * 获取类对应的Lambda
     * @param fn
     * @return
     */
    private static SerializedLambda getSerializedLambda(Serializable fn){
        //先检查缓存中是否已存在
        SerializedLambda lambda = null;
        try{//提取SerializedLambda并缓存
            Method method = fn.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            lambda = (SerializedLambda) method.invoke(fn);
        }
        catch (Exception e){
//            log.error("获取SerializedLambda异常, class="+fn.getClass().getSimpleName(), e);
        }
        return lambda;
    }

    /***
     * 转换setter方法引用为属性名
     * @param fn
     * @return
     */
    public static <T,R> String convertToFieldName(ISetter<T,R> fn) {
        SerializedLambda lambda = getSerializedLambda(fn);
        String methodName = lambda.getImplMethodName();
        if(!methodName.startsWith("set")){

        }
        // 截取set之后的字符串并转换首字母为小写（S为diboot项目的字符串工具类，可自行实现）
        return methodName;
    }
}