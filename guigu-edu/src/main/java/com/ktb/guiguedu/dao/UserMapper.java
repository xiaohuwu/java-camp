package com.ktb.guiguedu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktb.guiguedu.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
