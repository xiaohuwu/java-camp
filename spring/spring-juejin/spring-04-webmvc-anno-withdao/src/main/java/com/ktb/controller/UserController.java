package com.ktb.controller;
import com.ktb.entity.User;
import com.ktb.entity.UserVo;
import com.ktb.service.DepartmentService;
import com.ktb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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



    @PostMapping("/save")
    public String save(@Validated User user, BindingResult bindingResult) {
        log.info("user:{}",user);
        Locale locale = new Locale("en", "US"); // 英文
        LocaleContextHolder.setLocale(locale);
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            throw new RuntimeException("数据格式不正确！");
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
    public UserVo batchUpdate(@RequestBody UserVo userVo, BindingResult bindingResult ) {
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
