package com.lou.springboot.dao;

import com.lou.springboot.model.User;

import java.util.List;

public interface UserDao {
    /**
     * 返回数据列表
     *
     * @return
     */
    List< User> findAllUsers();

    /**
     * 添加
     *
     * @param User
     * @return
     */
    int insertUser(User User);

    /**
     * 修改
     *
     * @param User
     * @return
     */
    int updateUser(User User);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteOne(Integer id);

    User getOne(Integer id);
}
