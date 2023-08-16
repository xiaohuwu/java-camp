package com.ktb.controller;

import com.ktb.entity.User;
import com.ktb.service.DepartmentService;
import com.ktb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

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
    public String save(User user) {
        userService.update(user);
        return "redirect:/user/list";
    }


    @PostMapping("/batchDelete")
    @ResponseBody
    public String batchDelete(@RequestParam("ids[]") List<String> ids) {
        log.info("ids:{}", ids);
        return Arrays.toString(ids.toArray());
    }

    @GetMapping("/edit")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("user", userService.findById(id));
        // 注意这个地方还要选择部门，要把所有的部门查出来
        request.setAttribute("depts", departmentService.findDepartments(null));
        return "user/userInfo";
    }
}
