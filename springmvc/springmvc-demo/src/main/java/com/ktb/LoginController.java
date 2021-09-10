package com.ktb;

import com.ktb.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
@RequestMapping("user")
public class LoginController {

    private Logger logger = LogManager.getLogger(getClass());
    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Integer id,String name){
        return "index";
    }

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPost(Integer id,String name){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String hello(){
        return "pre_login";
    }

    @RequestMapping(value = "/restful/{id}/{name}",method = RequestMethod.GET)
    public String restful(@PathVariable Integer id, @PathVariable String name){
        logger.info("id:"+id+"name:"+name);
        return "pre_login";
    }


    @RequestMapping(value = "/restful",method = RequestMethod.GET)
    public String getCookie(@CookieValue("JSESSIONID") String jsSessionId){
        logger.info("jsSessionId:"+jsSessionId);
        return "pre_login";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String userNew(User user){
        return "user_new";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String restful(User user){
        logger.info("user:"+user);
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
