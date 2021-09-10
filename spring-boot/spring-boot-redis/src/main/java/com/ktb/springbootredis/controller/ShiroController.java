package com.ktb.springbootredis.controller;
import com.ktb.springbootredis.mapper.SysMenuMapper;
import com.ktb.springbootredis.model.User;
import com.ktb.springbootredis.utils.ShiroUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShiroController {
    private static Logger LOGGER = LoggerFactory.getLogger(ShiroController.class) ;
    @Resource
    private SysMenuMapper sysMenuMapper ;
    /**
     * 登录测试
     * http://localhost:8080/userLogin?userName=admin&passWord=admin
     */
    @RequestMapping("/userLogin")
    public void userLogin (
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "passWord") String passWord){
        try{
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
            subject.login(token);
            LOGGER.info("登录成功");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 服务器每次重启请求该接口之前必须先请求上面登录接口
     * http://localhost:8080/menu/list 获取所有菜单列表
     * 权限要求：sys:user:shiro
     */
    @RequestMapping("/menu/list")
    @RequiresPermissions("sys:user:shiro")
    public List list(){
        return sysMenuMapper.selectList() ;
    }
    /**
     * 用户没有该权限，无法访问
     * 权限要求：ccc:ddd:bbb
     */
    @RequestMapping("/menu/list2")
    @RequiresPermissions("ccc:ddd:bbb")
    public List list2(){
        return sysMenuMapper.selectList() ;
    }
    /**
     * 退出测试，退出后没有任何权限
     */
    @RequestMapping("/userLogOut")
    public String logout (){
        ShiroUtils.logout();
        return "success" ;
    }


    /**
     *     <dependency>
     *             <groupId>com.fasterxml.jackson.dataformat</groupId>
     *             <artifactId>jackson-dataformat-xml</artifactId>
     *         </dependency>
     *         produces = MediaType.APPLICATION_XML_VALUE
     *         就可以转xml
     * @param user
     * @return
     */
    @PostMapping(value = "/user",
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User create(@RequestBody User user) {
        user.setUsername("com: " + user.getUsername());
        user.setId(user.getId() + 100);
        return user;
    }

}
