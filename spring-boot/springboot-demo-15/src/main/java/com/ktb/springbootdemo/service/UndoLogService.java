package com.ktb.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;


import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-10 14:19:12
 */
public interface UndoLogService  {
    void queryPage(Map<String, Object> params);
}

