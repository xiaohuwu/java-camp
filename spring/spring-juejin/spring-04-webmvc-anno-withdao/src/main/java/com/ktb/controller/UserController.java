package com.ktb.controller;

import com.ktb.entity.User;
import com.ktb.entity.UserVo;
import com.ktb.service.DepartmentService;
import com.ktb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/list")
    public String list(ModelMap map) {
        map.put("userList", userService.findAllUsers());
        return "user/userList";
    }


    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> getPhoto(String id) throws UnsupportedEncodingException {
        User user = userService.findById(id);
        byte[] photo = user.getPhoto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(user.getUsername() + ".jpg", "utf-8"));
        return new ResponseEntity<>(photo, headers, HttpStatus.CREATED);
    }


    @PostMapping("/save")
    public String save(@Validated User user, MultipartFile photoFile, BindingResult bindingResult) throws IOException {
        if (StringUtils.isEmpty(user.getName())) {
            throw new IllegalArgumentException("User的name为空");
        }

        if (bindingResult.hasErrors()) {
            throw new RuntimeException("数据格式不正确！");
        }
        log.info("user:{}", user);
//        Locale locale = new Locale("en", "US"); // 英文
//        LocaleContextHolder.setLocale(locale);
//        if (bindingResult.hasErrors()) {
//            bindingResult.getAllErrors()
//                    .forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
//            throw new RuntimeException("数据格式不正确！");
//        }
        System.out.println(user);
        if (photoFile != null) {
            System.out.println(photoFile);
            user.setPhoto(photoFile.getBytes());
        }
        userService.update(user);
        return "redirect:/user/list";
    }


    @PostMapping("/batchDelete")
    @ResponseBody
    public String batchDelete(@RequestParam("ids[]") List<String> ids) {
        log.info("ids:{}", ids);
        return Arrays.toString(ids.toArray());
    }


    @PostMapping("/batchUpdate")
    @ResponseBody
    public UserVo batchUpdate(@RequestBody UserVo userVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            throw new RuntimeException("数据格式不正确！");
        }
        log.info("userVo:{}", userVo);
        return userVo;
    }


    @GetMapping("/edit")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("user", userService.findById(id));
        // 注意这个地方还要选择部门，要把所有的部门查出来
        request.setAttribute("depts", departmentService.findDepartments(null));
        return "user/userInfo";
    }


}
