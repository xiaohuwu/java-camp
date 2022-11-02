package com.ktb.newbee.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktb.newbee.entity.IndexConfig;

import java.util.List;

/**
 * (IndexConfig)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-02 15:00:17
 */
public interface IndexConfigDao extends BaseMapper<IndexConfig> {

    public List<IndexConfig> getIndexConfigs(int configType);

}

