package com.ktb.demo.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void out(String outer, int money) {
        getJdbcTemplate().update("update account set money = money - ? where username = ? ", new Object[]{money, outer});
    }

    @Override
    public void in(String inner, int money) {
        getJdbcTemplate().update("update account set money = money + ? where username = ? ", new Object[]{money, inner});
    }
}
