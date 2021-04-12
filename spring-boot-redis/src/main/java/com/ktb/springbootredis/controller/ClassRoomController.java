package com.ktb.springbootredis.controller;

import com.ktb.springbootredis.entity.ClassRoom;
import com.ktb.springbootredis.service.ClassRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ClassRoom)表控制层
 *
 * @author makejava
 * @since 2021-04-12 21:27:02
 */
@RestController
@RequestMapping("classRoom")
public class ClassRoomController {
    /**
     * 服务对象
     */
    @Resource
    private ClassRoomService classRoomService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ClassRoom selectOne(Integer id) {
        return this.classRoomService.queryById(id);
    }

}
