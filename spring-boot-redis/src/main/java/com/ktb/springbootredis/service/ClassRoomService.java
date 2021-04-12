package com.ktb.springbootredis.service;

import com.ktb.springbootredis.entity.ClassRoom;

import java.util.List;

/**
 * (ClassRoom)表服务接口
 *
 * @author makejava
 * @since 2021-04-12 21:26:58
 */
public interface ClassRoomService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassRoom queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ClassRoom> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param classRoom 实例对象
     * @return 实例对象
     */
    ClassRoom insert(ClassRoom classRoom);

    /**
     * 修改数据
     *
     * @param classRoom 实例对象
     * @return 实例对象
     */
    ClassRoom update(ClassRoom classRoom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
