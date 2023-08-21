package com.ktb.controller;

import com.ktb.entity.Department;
import com.ktb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;
//    protected final Log logger = LogFactory.getLog(getClass());


    @GetMapping("/findById/{id}")
    @ResponseBody
    public Department findById(@PathVariable String id) {
        Department department = departmentService.findById(id);
        int s = 1 + 2;
        log.info("s============123456");
        return department;
    }


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


    @GetMapping("/edit/{id}")
    public String edit(HttpServletRequest request, @PathVariable String id) {
        request.setAttribute("dept", departmentService.findById(id));
        return "dept/edit";
    }

    @PostMapping("/")
    public String save(Department department) {
        log.error("department：" + department);
        departmentService.save(department);
        return "redirect:/department/list";
    }

    @PostMapping("/saveJson")
    @ResponseBody
    public Department saveJson(@RequestBody Department department) {
        log.error("department：" + department);
        departmentService.save(department);
        return department;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, @RequestParam(value = "dept_name", required = false) String name) {
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/list";
    }


}


