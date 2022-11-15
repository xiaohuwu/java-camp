package com.ktb.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDaoMybatiesImpl implements AlphaDao {

    @Override
    public String select() {
        return "AlphaDaoMybatiesImpl";
    }
}
