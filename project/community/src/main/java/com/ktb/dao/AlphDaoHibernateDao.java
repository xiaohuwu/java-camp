package com.ktb.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphDaoHibernateDao implements AlphaDao {
    @Override
    public String select() {
        return "AlphDaoHibernateDao";
    }
}
