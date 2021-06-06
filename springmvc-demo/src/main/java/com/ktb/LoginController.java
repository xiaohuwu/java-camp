package com.ktb;

import com.ktb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
@RequestMapping("hello")
public class LoginController {

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
