package com.ktb.controller;

import com.ktb.entity.Department;
import com.ktb.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/departments")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;


    @RequestMapping("/demo")
    public String demo() {
        System.out.println(departmentService);
        return "demo";
    }

    @DeleteMapping("/{id}")
    public String delete(String id) {
        departmentService.deleteById(id);
        return "dept/list";
    }


    @GetMapping("/{id}")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("dept", departmentService.findById(id));
        return "dept/edit";
    }

    @PostMapping("/")
    public String save(Department department) {
        log.error("department：" + department);
        departmentService.save(department);
        return "redirect:/department/list";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(HttpServletRequest request, @RequestParam(value = "dept_name", required = false) String name) {
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/list";
    }


}


