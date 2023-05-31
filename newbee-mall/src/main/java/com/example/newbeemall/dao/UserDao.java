package com.example.newbeemall.dao;


import com.example.newbeemall.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 返回数据列表
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     * 添加
     *
     * @param User
     * @return
     */
    int insert(User User);

    /**
     * 修改
     *
     * @param User
     * @return
     */
    int update(User User);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);
}
