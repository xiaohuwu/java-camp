package com.ktb.springbootredis.dao;

import com.ktb.springbootredis.entity.ClassRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ClassRoom)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-12 21:26:55
 */
public interface ClassRoomDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassRoom queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ClassRoom> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param classRoom 实例对象
     * @return 对象列表
     */
    List<ClassRoom> queryAll(ClassRoom classRoom);

    /**
     * 新增数据
     *
     * @param classRoom 实例对象
     * @return 影响行数
     */
    int insert(ClassRoom classRoom);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassRoom> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ClassRoom> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassRoom> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ClassRoom> entities);

    /**
     * 修改数据
     *
     * @param classRoom 实例对象
     * @return 影响行数
     */
    int update(ClassRoom classRoom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

