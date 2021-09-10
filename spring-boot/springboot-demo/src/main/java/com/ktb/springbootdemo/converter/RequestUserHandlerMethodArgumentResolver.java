package com.ktb.springbootdemo.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ktb.springbootdemo.config.RequestUser;
import com.ktb.springbootdemo.model.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class RequestUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return  parameter.hasParameterAnnotation(RequestUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //这里以后可以是JWTtoken 解析后可以得到user_id

        HttpServletRequest nativeRequest = (HttpServletRequest) webRequest.getNativeRequest();
        Object token = nativeRequest.getParameter("token");
//        nativeRequest.getParameterMap();
        Object object = webRequest.getAttribute("token", RequestAttributes.SCOPE_REQUEST);
        if (token == null) {
            System.out.println("token为空");
        }else{
            JSONObject json=new JSONObject();
            json.put("id",201904081723L);
            json.put("name","张三丰");
            json.put("age","23");
            token=json;
        }
        //获取用户信息
        User userInfoDto = JSON.parseObject(token.toString(), User.class);
        return userInfoDto;
    }
}
