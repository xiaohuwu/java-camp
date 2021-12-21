package com.lou.springboot.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class KaptchaController {

    @GetMapping("/kaptcha")
    public void  defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/gif");

        // 三个参数分别为宽、高、位数
        GifCaptcha captcha = new GifCaptcha(75, 30,4);

        // 设置类型 数字和字母混合
        captcha.setCharType(Captcha.TYPE_DEFAULT);

        // 设置字体
        captcha.setCharType(Captcha.FONT_9);

        // 验证码存入 session
        httpServletRequest.getSession().setAttribute("verifyCode", captcha.text().toLowerCase());

        // 输出图片流
        captcha.out(httpServletResponse.getOutputStream());
        List list = Arrays.asList(new String[]{"one","TWo","three"});
        Arrays.toString(new String[]{"one","TWo","three"});
        list.forEach(System.out::println);
    }

    @GetMapping("/verify")
    @ResponseBody
    public Boolean verify(HttpServletRequest httpServletRequest,String code){
        Object verifyCode = httpServletRequest.getSession().getAttribute("verifyCode");
        System.out.println();
        if (code != null && verifyCode!= null && verifyCode.equals(code.toLowerCase())) {
            return true;
        }
        return false;
    }
}
