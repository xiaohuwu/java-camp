package com.ktb.newbee.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktb.newbee.config.Result;
import com.ktb.newbee.entity.param.LoginParam;
import com.ktb.newbee.entity.User;
import com.ktb.newbee.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (beeMallUser)表控制层
 *
 * @author makejava
 * @since 2022-10-31 14:30:28
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<Object> login(@RequestBody LoginParam param) {
        return userService.login(param);
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public Result selectAll(Page<User> page, User user) {
        Page<User> page1 = this.userService.page(page, new QueryWrapper<>(user));
        return Result.ok(page1);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return Result.ok(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody User user) {
        return Result.ok(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        return Result.ok(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.ok(this.userService.removeByIds(idList));
    }
}

