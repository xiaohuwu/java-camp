package com.ktb.controller;
import com.ktb.config.ResponseResult;
import com.ktb.entity.User;
import com.ktb.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-10-28 14:24:28
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ResponseResult selectOne(Integer id) {
        return new ResponseResult(200,this.userService.queryById(id));
    }

    @GetMapping("/list")
    public List<User> list() {
        return this.userService.queryAllByLimit(0, 10);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userService.insert(user);
    }
}
