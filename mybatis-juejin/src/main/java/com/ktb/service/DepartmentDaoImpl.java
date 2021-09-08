package com.ktb.service;

import com.ktb.dao.DepartmentDao;
import com.ktb.entity.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    SqlSessionFactory sqlSessionFactory;

    public DepartmentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Department> findAll() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("com.ktb.dao.DepartmentDao.findAll");
        }
    }

    @Override
    public Department findById(String id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("com.ktb.dao.DepartmentDao.findById",id);
        }
    }

    @Override
    public int save(Department department) {
        return 0;
    }

    @Override
    public int update(Department department) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }


}
