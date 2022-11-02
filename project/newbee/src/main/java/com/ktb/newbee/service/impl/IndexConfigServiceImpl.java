package com.ktb.newbee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.newbee.dao.IndexConfigDao;
import com.ktb.newbee.entity.IndexConfig;
import com.ktb.newbee.service.IndexConfigService;
import org.springframework.stereotype.Service;

/**
 * (IndexConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-11-02 15:00:17
 */
@Service("indexConfigService")
public class IndexConfigServiceImpl extends ServiceImpl<IndexConfigDao, IndexConfig> implements IndexConfigService {

}

