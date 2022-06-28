package com.ktb.springbootdemo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktb.springbootdemo.GamePHP;
import com.ktb.springbootdemo.config.RequestUser;
import com.ktb.springbootdemo.model.Product;
import com.ktb.springbootdemo.model.User;
import com.ktb.springbootdemo.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Slf4j
public class UserController {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        ObjectMapper objectMapper = new ObjectMapper();
        binder.registerCustomEditor(Product.class, new ProductEditor(objectMapper));
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/xxx-junlin")
    public Object getList() {
        log.info("getList===");
        UserEntity u1 = new UserEntity(null, "shanghai");
        return u1;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/convert")
    public @ResponseBody
    UserEntity converter(@RequestBody UserEntity user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testUser")
    public User testUser(@RequestUser User user) {
        return user;
    }

    @GetMapping("/mytest")
    public ResponseEntity test(@RequestParam Map<String, Object> params, WebRequest httpServletRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("hello", "goood");
        String eTag = "100";
        if (eTag != null && httpServletRequest.checkNotModified(eTag)) {
            log.info("return null");
            return null;
        }
        return ResponseEntity.ok()
                .eTag(Long.toString(100))
                .body(hashMap);
    }


    @GetMapping("/getProduct")
    @ResponseBody
    public Product getProduct(Product product) throws JsonMappingException, JsonProcessingException {
        return product;
    }

    @PostMapping("/get2")
    @ResponseBody
    public Product get2(@GamePHP Product product) throws JsonMappingException, JsonProcessingException {
        return product;
    }


}
