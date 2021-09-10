package com.ktb.springbootdemo.service.impl;

import com.ktb.springbootdemo.service.UndoLogService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("UndoLogService")
public class UndoLogServiceImpl implements UndoLogService {
    @Override
    public void queryPage(Map<String, Object> params) {
        System.out.println("ok+++++++++++++");
    }
}
