package com.ktb.annotation.a_quickstart.service.impl;

import com.ktb.annotation.a_quickstart.dao.AccountDao;
import com.ktb.annotation.a_quickstart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    @Override
    public void transfer(int in_id, int out_id, Double out_money) {
        accountDao.updateMoney(in_id, out_money);
        int i = 1 / 0;
        accountDao.updateMoney(out_id, out_money * -1);
    }
}
