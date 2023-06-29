package com.ktb.controller;

import com.ktb.model.User;
import com.ktb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    public static final String KEY_USER = "__user__";


    @Autowired
    UserService userService;


    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleUnknowException(Exception ex) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("error", ex.getClass().getSimpleName());
        hashMap.put("message", ex.getMessage());
        return new ModelAndView("500.html", hashMap);
    }


    @PostMapping(value = "/rest", consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String rest(@RequestBody User user) {
        return "{\"restSupport\":true}";
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession session) {
        User user = (User) session.getAttribute(KEY_USER);
        Map<String, Object> model = new HashMap<>();
        if (user != null) {
            model.put("user", model);
        }
        return new ModelAndView("index.html", model);
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register.html");
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name) {
        try {
            User user = userService.register(email, password, name);
            log.info("user registered: {}", user.getEmail());
        } catch (RuntimeException e) {
//            return new ModelAndView("register.html", Map.of("email", email, "error", "Register failed"));
        }
        return new ModelAndView("redirect:/signin");
    }

    @GetMapping("/signin")
    public ModelAndView signin(HttpSession session) {
        User user = (User) session.getAttribute(KEY_USER);
        if (user != null) {
            return new ModelAndView("redirect:/profile");
        }
        return new ModelAndView("signin.html");
    }

    @PostMapping("/signin")
    public ModelAndView doSignin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        try {
            User user = userService.signin(email, password);
            session.setAttribute(KEY_USER, user);
        } catch (RuntimeException e) {
            return new ModelAndView("signin.html");
        }
        return new ModelAndView("redirect:/profile");
    }

    @GetMapping("/profile")
    public ModelAndView profile(HttpSession session) {
        int result = 1 / 0;
        return new ModelAndView("profile.html");
    }

    @GetMapping("/signout")
    public String signout(HttpSession session) {
        session.removeAttribute(KEY_USER);
        return "redirect:/signin";
    }
}