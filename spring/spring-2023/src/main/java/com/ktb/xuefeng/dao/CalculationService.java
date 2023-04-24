package com.ktb.xuefeng.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalculationService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(int a ){
        int i = a / 0;
        return 1;
    }
}
