package com.ktb.demo.tx;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED , isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {


    AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outer, String inner, int money) {
        accountDao.out(outer,money);
        int i = 1/0;
        accountDao.in(inner,money);
    }
}
