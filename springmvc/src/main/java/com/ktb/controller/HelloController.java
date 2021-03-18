package com.ktb.controller;

import com.ktb.controller.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE) //response header  Content-Type: application/xml
    @ResponseBody
    public  String handleJson() {
        System.out.println("Got json request");
        return "{ \"userName\": \"Joe\"}";
    }

    @RequestMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public String handleXML() {
        System.out.println("Got xml request");
        return "success";
    }
}