package com.ktb.annotation.a_quickstart.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {

    void updateMoney(@Param("id") Integer id, @Param("updateMoney") Double updateMoney);
}
