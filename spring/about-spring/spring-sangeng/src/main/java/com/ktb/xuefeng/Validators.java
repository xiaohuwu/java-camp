package com.ktb.xuefeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Validators {

    @Autowired
    public List<Validator> validators;

    public List<Validator> getValidators() {
        return validators;
    }


}
