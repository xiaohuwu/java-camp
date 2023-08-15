package com.ktb;

import com.ktb.model.Book;
import com.ktb.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
//   https://blog.csdn.net/zengxianxue/article/details/78567544
@Controller
@SessionAttributes("name")
@RequestMapping("user")
public class LoginController {

    private Logger logger = LogManager.getLogger(getClass());
    @Autowired
    LoginService loginService;


//    @ModelAttribute
//    public void addAttributes(Model model) {
//        model.addAttribute("msg", "欢迎访问 hangge.com");
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "hangge");
//        map.put("age", "100");
//        model.addAttribute("info", map);
//    }


    @InitBinder("user")
    public void init1(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("book")
    public void init2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("book.");
    }


    @GetMapping("/hello2")
    @ResponseBody
    public String hello2(HttpServletRequest serverHttpRequest) {
        StringBuilder result = new StringBuilder();

        // 获取所有参数的名称
        Enumeration<String> parameterNames = serverHttpRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            result.append("Parameter: ").append(paramName).append("<br>");

            // 获取参数值
            String[] paramValues = serverHttpRequest.getParameterValues(paramName);
            for (String paramValue : paramValues) {
                result.append("Value: ").append(paramValue).append("<br>");
            }
        }

        return result.toString();
    }

    @GetMapping("/hello1")
    @ResponseBody
    public String hello1(@ModelAttribute("user") User user,
                         @ModelAttribute("book") Book book) {
        return "name：" + user.getName() + " | age：" + user.getAge() + "<br>"
                + "name：" + book.getName() + " | price：" + book.getPrice();
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@ModelAttribute("msg") String msg) {
        String result = "msg:" + msg + "<br>";
        return result;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Integer id, String name) {
        logger.info("test one two");
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String indexPost(Integer id, String name) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String hello() {
        return "pre_login";
    }

    @RequestMapping(value = "/restful/{id}/{name}", method = RequestMethod.GET)
    public String restful(@PathVariable Integer id, @PathVariable String name) {
        logger.info("id:" + id + "name:" + name);
        return "pre_login";
    }


    @RequestMapping(value = "/restful", method = RequestMethod.GET)
    public String getCookie(@CookieValue("JSESSIONID") String jsSessionId) {
        logger.info("jsSessionId:" + jsSessionId);
        return "pre_login";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String userNew(User user) {
        return "user_new";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String restful(User user) {
        logger.info("user:" + user);
        return "pre_login";
    }


//    @RequestMapping(value = "/do_login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String login(@RequestBody User user, ModelMap modelMap){
//        System.out.println("user=======>:"+user.toString());
//        if(loginService.validateUser(user.getName(),user.getPassword())){
//            modelMap.addAttribute("user",user);
//            return "welcome";
//        } else{
//            modelMap.addAttribute("error","name or password not right");
//            return "pre_login";
//        }
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleUserLogin(ModelMap model, @RequestParam String name,
                                  @RequestParam String password) {
        if (!loginService.validateUser(name, password)) {
            model.put("errorMessage", "Invalid Credentials");
            return "pre_login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
}
