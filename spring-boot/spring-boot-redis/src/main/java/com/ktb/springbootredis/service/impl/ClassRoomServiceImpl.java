package com.ktb.springbootredis.service.impl;

import com.ktb.springbootredis.entity.ClassRoom;
import com.ktb.springbootredis.dao.ClassRoomDao;
import com.ktb.springbootredis.service.ClassRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ClassRoom)表服务实现类
 *
 * @author makejava
 * @since 2021-04-12 21:27:00
 */
@Service("classRoomService")
public class ClassRoomServiceImpl implements ClassRoomService {
    @Resource
    private ClassRoomDao classRoomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ClassRoom queryById(Integer id) {
        return this.classRoomDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ClassRoom> queryAllByLimit(int offset, int limit) {
        return this.classRoomDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param classRoom 实例对象
     * @return 实例对象
     */
    @Override
    public ClassRoom insert(ClassRoom classRoom) {
        this.classRoomDao.insert(classRoom);
        return classRoom;
    }

    /**
     * 修改数据
     *
     * @param classRoom 实例对象
     * @return 实例对象
     */
    @Override
    public ClassRoom update(ClassRoom classRoom) {
        this.classRoomDao.update(classRoom);
        return this.queryById(classRoom.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.classRoomDao.deleteById(id) > 0;
    }
}
