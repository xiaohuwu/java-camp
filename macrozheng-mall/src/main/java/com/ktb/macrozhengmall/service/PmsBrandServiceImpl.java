package com.ktb.macrozhengmall.service;

import com.github.pagehelper.PageHelper;
import com.ktb.macrozhengmall.dao.PmsBrandMapper;
import com.ktb.macrozhengmall.model.PmsBrand;
import com.ktb.macrozhengmall.model.PmsBrandExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    PmsBrandMapper PmsBrandMapper;

    public PmsBrandServiceImpl(PmsBrandMapper PmsBrandMapper) {
        this.PmsBrandMapper = PmsBrandMapper;
    }


    @Override
    public List<PmsBrand> listAllBrand() {
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        return PmsBrandMapper.selectByExample(pmsBrandExample);
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return PmsBrandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return PmsBrandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return PmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return PmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return PmsBrandMapper.selectByPrimaryKey(id);
    }
}
