package com.ktb.controller;

import com.ktb.model.User;
import com.ktb.utils.DownLoadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ReviewController {


    @RequestMapping(value = "/testPath", params = "testParam=123", headers = "testHeader=123", method = RequestMethod.GET)
    public String test() {
        return "/success.jsp";
    }

    @RequestMapping(value = "/testPath1", consumes = "application/json")
    public String test1() {
        return "/success.jsp";
    }

    @RequestMapping(value = "/queryId/{id}", consumes = "application/json")
    public String test2(@PathVariable("id") String id) {
        System.out.println("id = " + id);
        return "/success.jsp";
    }


    /**
     * 如果需要使用**@RequestBody**来获取请求体中Json并且进行转换，要求请求头 Content-Type 的值要为： application/json
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", consumes = "application/json")
    public String test3(@RequestBody List<User> user) {
        System.out.println("id = " + user);
        return user.toString();
    }


    /**
     * http://localhost:8080/userQuery?name=geg&age=24
     *
     * @param user
     * @return
     */

    @RequestMapping(value = "/userQuery5", consumes = "application/json")
    public String test4(User user) {
        System.out.println("id = " + user);
        return user.toString();
    }


    /**
     * success.jsp 如果不通过controler访问 需要直接放在 webapp下
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/redirect")
    public String redirect(User user) {
        System.out.println("id = " + user);
        return "redirect:/success.jsp";
    }


    @RequestMapping(value = "/getHeader", method = RequestMethod.GET)
    @ResponseBody
    public String getHeader(@RequestHeader(value = "device-type") String deviceType) {
        System.out.println("deviceType = " + deviceType);
        return "redirect:/success.jsp";
    }


    @RequestMapping(value = "/login_new", method = RequestMethod.GET)
    public String login_new() {
        return "login_new";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userName, HttpSession session, MultipartFile portrait) throws IOException {
        portrait.transferTo(new File("./elderly.png"));
        session.setAttribute("userName", userName);
        return "redirect:/success.jsp";
    }


    @RequestMapping(value = "/donwload", method = RequestMethod.GET)
    public void donwload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DownLoadUtils.downloadFile("/Users/jonny/Documents/elderly.png", request.getServletContext(), response);
    }

}
