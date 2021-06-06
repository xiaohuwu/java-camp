package com.ktb;

import com.google.gson.Gson;
import com.ktb.model.SysLogEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

@Aspect
@Component
public class SysLogAspect {
//    protected static final Logger parentLogger = LogManager.getLogger(SysLogAspect.class);
    private Logger logger = LogManager.getLogger(getClass());

    @Pointcut("execution(public * com.ktb..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
         logger.info("processing "+request.getMethod()+" request for"+" " + request.getRequestURL().toString() +"  from "+ request.getRemoteAddr());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

//
//        logger.info("map : " + new Gson().toJson(map));
//        Map map=request.getParameterMap();
//        Set keSet=map.entrySet();
//        for(Iterator itr = keSet.iterator(); itr.hasNext();){
//            Map.Entry me=(Map.Entry)itr.next();
//            Object ok=me.getKey();
//            Object ov=me.getValue();
//            String[] value=new String[1];
//            if(ov instanceof String[]){
//                value=(String[])ov;
//            }else{
//                value[0]=ov.toString();
//            }
//            for(int k=0;k<value.length;k++){
//                System.out.println(ok+"="+value[k]);
//            }
//        }
        HashMap<String, Object> params = new HashMap<>();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            params.put(paraName,request.getParameter(paraName));
        }
        logger.info("params:"+new Gson().toJson(params));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret);
    }


}
